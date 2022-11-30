package br.ufms.danilo.pacotesviagensapi.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.ufms.danilo.pacotesviagensapi.models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>, QueryByExampleExecutor<Viagem> {
    
    @Query("UPDATE Viagem v SET v.situacao = :situacao WHERE v.id=:id")
    void atualizaSituacao(@Param("id") Long viagemId,@Param("situacao") String situacao );
    
}
