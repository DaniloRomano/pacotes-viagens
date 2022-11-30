package br.ufms.danilo.pacotesviagensapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_viajante")
@Data
public class Viajante {
    private static final Logger LOGGER= LoggerFactory.getLogger(Viajante.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_viajante")
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String telefone;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = true)
    private String password;

    @ManyToMany(mappedBy = "viajantes", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("viajantes")
    private List<Viagem> viagens;

    public void setPassword(String password){
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes(), 0, password.length());
            this.password= new BigInteger(1, md5.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Erro ao encriptar a senha",e);
        }
    }

}
