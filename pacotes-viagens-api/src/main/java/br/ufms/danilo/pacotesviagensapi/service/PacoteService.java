package br.ufms.danilo.pacotesviagensapi.service;

import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.models.Pacote;
import br.ufms.danilo.pacotesviagensapi.repository.PacoteRepository;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacoteService {

    @Autowired
    private DestinoService destinoService;

    @Autowired
    private PacoteRepository repository;

    public Optional<Pacote> findById(Long id) {
        return repository.findById(id);
    }

    public Page<Pacote> findAllByFilter(Pacote filter, Pageable pageable) {
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withMatcher("destino.id", matcher -> matcher.exact())
                .withMatcher("descricao", matcher -> matcher.contains())
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example example = Example.of(filter, exampleMatcher);

        return repository.findAll(example, pageable);
    }

    @Transactional
    public Pacote inserir(Pacote pacote) throws BadRequestException {
        carregaDestino(pacote);
        validModel(pacote);
        return repository.save(pacote);
    }

    @Transactional
    public Pacote alterar(Pacote pacote) throws BadRequestException {
        carregaDestino(pacote);
        validModel(pacote);

        return repository.save(pacote);

    }

    @Transactional
    public void deletar(Pacote pacote) {
        repository.delete(pacote);
    }

    private void carregaDestino(Pacote pacote) {
        Long destinoId = pacote.getDestino().getId();
        pacote.setDestino(destinoService.findById(destinoId));
    }

    private void validModel(Pacote pacote) throws BadRequestException {
        if (
                Objects.isNull(pacote.getDescricao())
                        || pacote.getDescricao().isEmpty()
                        || Objects.isNull(pacote.getDestino())
        ) throw new BadRequestException("Existem campos obrigatórios sem preenchimento.");

    }
}
