package br.ufms.danilo.pacotesviagensapi.service;

import br.ufms.danilo.pacotesviagensapi.dto.DestinoDto;
import br.ufms.danilo.pacotesviagensapi.models.Destino;
import br.ufms.danilo.pacotesviagensapi.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DestinoService {

  @Autowired
  private DestinoRepository destinoRepository;

  public Page<Destino> findAllByFilter(Pageable pageable, String nome) {
    Destino destinoModel = new Destino();
    destinoModel.setNome(nome);

    ExampleMatcher matcher = ExampleMatcher
      .matching()
      .withMatcher("nome", matcherNome -> matcherNome.contains())
      .withIgnoreCase();

    Example destinoFilterExample = Example.of(destinoModel, matcher);

    return destinoRepository.findAll(destinoFilterExample, pageable);
  }

  public Destino findById(Long id){
    return destinoRepository.findById(id).orElse(null);
  }

  public Destino insertNew(Destino destino) {
    return destinoRepository.save(destino);
  }

  public Destino alterar(Destino destino){
    return destinoRepository.save(destino);
  }

  public void deletar(Long destinoId) {
    destinoRepository.deleteById(destinoId);
  }
}
