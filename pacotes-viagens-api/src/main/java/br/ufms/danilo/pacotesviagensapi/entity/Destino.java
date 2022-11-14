package br.ufms.danilo.pacotesviagensapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DESTINO")
@Data
@NoArgsConstructor
@Relation(collectionRelation = "destinos",itemRelation = "destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200)
    private String nome;
}
