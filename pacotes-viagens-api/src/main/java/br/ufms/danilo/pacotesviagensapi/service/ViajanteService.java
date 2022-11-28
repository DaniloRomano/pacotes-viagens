package br.ufms.danilo.pacotesviagensapi.service;

import java.util.List;

import br.ufms.danilo.pacotesviagensapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.exceptions.InvalidDocumentException;
import br.ufms.danilo.pacotesviagensapi.models.Viajante;
import br.ufms.danilo.pacotesviagensapi.repository.ViajanteRepository;
import static br.ufms.danilo.pacotesviagensapi.utils.ValidarCPFUtils.isCPF;

import java.util.Date;

@Service
public class ViajanteService {
    
    @Autowired
    private ViajanteRepository repository;

    public Page<Viajante> findAllByFilter(Viajante viajante, Pageable pageable){
        ExampleMatcher matcher= ExampleMatcher.matching()
                .withMatcher("nome", ExampleMatcher.GenericPropertyMatcher::contains)
                .withMatcher("cpf", ExampleMatcher.GenericPropertyMatcher::contains)
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example<Viajante> example=Example.of(viajante,matcher);

        return repository.findAll(example,pageable);
    }

    public Viajante findById(Viajante viajante) throws NotFoundException {
        return repository.findById(viajante.getId()).orElseThrow(()-> new NotFoundException("Viajante não encontrado"));
    }

    public List<Viajante> findByViagemId(Long viagemId){
        return repository.buscaViajantesDaViagem(viagemId);
    }

    @Transactional
    public Viajante salvar(Viajante viajante) throws InvalidDocumentException, BadRequestException{
        validar(viajante);
        return repository.save(viajante);
    }    

    @Transactional
    public void remover(Viajante viajante){
        repository.delete(viajante);
    }

    private void validar(Viajante viajante) throws InvalidDocumentException, BadRequestException{
        if (!isCPF(viajante.getCpf())){
            throw new InvalidDocumentException(String.format("CPF %s não é valido.",viajante.getCpf()));
        }

        if (viajante.getNome().isEmpty())
            throw new BadRequestException("Nome deve estar preenchido");

        if (viajante.getDataNascimento().compareTo(new Date(System.currentTimeMillis()))>0)
            throw new BadRequestException("A Data de nascimento já deve ter ocorrido.");
    }

    public Viajante login(Viajante viajante){
        return repository.findViajanteByCpfAndPassword(viajante.getCpf(), viajante.getPassword());
    }
}
