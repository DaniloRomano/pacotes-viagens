package br.ufms.danilo.pacotesviagensapi.service;

import br.ufms.danilo.pacotesviagensapi.enumerations.EnumSituacoesViagem;
import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.exceptions.NotFoundException;
import br.ufms.danilo.pacotesviagensapi.models.Viagem;
import br.ufms.danilo.pacotesviagensapi.repository.ViagemRepository;

import java.util.Calendar;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository repository;

    public Page<Viagem> findAllByFilter(Viagem viagem, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withMatcher("situacao", match -> match.exact())
                .withMatcher("pacote.id", match -> match.exact())
                .withIgnoreCase()
                .withIgnoreNullValues();

        Example example = Example.of(viagem, matcher);

        return repository.findAll(example, pageable);
    }

    public Optional<Viagem> findById(Long viagemId) {
        return repository.findById(viagemId);
    }

    @Transactional
    public Viagem inserir(Viagem viagem) throws BadRequestException {
        validar(viagem);

        return repository.save(viagem);
    }

    @Transactional
    public void cancelarViagem(Long id) throws Exception {
        Viagem viagem = repository.findById(id).orElseThrow(() -> new NotFoundException("Viagem não encontrada"));

        Locale locale=Locale.getDefault();
        Calendar dataAtual=Calendar.getInstance(locale);        
        dataAtual.add(Calendar.DATE, -15);

        if (viagem.getDataSaida().compareTo(dataAtual.getTime())>0){
            throw new Exception("O Cancelamento só é permitido com 15 dias de antecedencia.");
        }

        if (
                viagem.getSituacao().equals(EnumSituacoesViagem.REALIZADA)
        ) throw new Exception("Não é possível cancelar uma viagem já Realizada.");

        repository.atualizaSituacao(viagem.getId(), EnumSituacoesViagem.CANCELADA.toString());

    }

    private void validar(Viagem viagem) throws BadRequestException {
        Locale locale=Locale.getDefault();
        Calendar dataAtual=Calendar.getInstance(locale);        

        if (viagem.getDataSaida().compareTo(dataAtual.getTime())<0){
            throw new BadRequestException("Não é possível marcar uma viagem para uma data que já passou.");
        }
    }
}
