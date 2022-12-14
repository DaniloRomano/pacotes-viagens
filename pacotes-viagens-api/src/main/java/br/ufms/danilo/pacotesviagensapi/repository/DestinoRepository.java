package br.ufms.danilo.pacotesviagensapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.ufms.danilo.pacotesviagensapi.models.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long>, QueryByExampleExecutor<Destino> {
}
