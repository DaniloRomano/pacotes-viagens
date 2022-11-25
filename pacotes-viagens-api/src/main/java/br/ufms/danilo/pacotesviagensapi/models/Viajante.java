package br.ufms.danilo.pacotesviagensapi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ForeignKey;

import lombok.Data;

@Entity
@Table(name="tb_viajante")
@Data
public class Viajante {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "seq_viajante")
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String telefone;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "viajantes",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("viajantes")
    private List<Viagem> viagens;
}
