package br.ufms.danilo.pacotesviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufms.danilo.pacotesviagensapi.models.Viajante;

import java.util.List;

@Repository
public interface ViajanteRepository extends JpaRepository<Viajante, Long>{

    @Query("SELECT v from Viajante v " +
            "join Viagem viagem where viagem.id=:viagemId ")
    List<Viajante> buscaViajantesDaViagem(@Param("viagemId") Long viagemId);

    @Query("SELECT v FROM Viajante v " +
            "WHERE v.cpf=:cpf and v.password=:password")
    Viajante findViajanteByCpfAndPassword(@Param("cpf") String cpf, @Param("password") String password);
}
