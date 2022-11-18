package br.ufms.danilo.pacotesviagensapi.repository;

import br.ufms.danilo.pacotesviagensapi.entity.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>, QueryByExampleExecutor<Destino> {
}
