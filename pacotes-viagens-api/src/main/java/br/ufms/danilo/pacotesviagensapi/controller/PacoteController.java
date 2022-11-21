package br.ufms.danilo.pacotesviagensapi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufms.danilo.pacotesviagensapi.converter.PacoteConverter;
import br.ufms.danilo.pacotesviagensapi.dto.PacoteDto;
import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.exceptions.NotFoundException;
import br.ufms.danilo.pacotesviagensapi.models.Pacote;
import br.ufms.danilo.pacotesviagensapi.service.PacoteService;

@RestController
@RequestMapping("/v1/pacote")
public class PacoteController {

    @Autowired
    private PacoteService service;

    @Autowired
    private PacoteConverter converter;

    @GetMapping
    public ResponseEntity<Page<Pacote>> findAllByFilter(@RequestParam Map<String, String> filter, Pageable pageable){
        return ResponseEntity.ok(service.findAllByFilter(converter.parseMapToPacote(filter),pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pacote> findBydId(@PathVariable("id") Long id) throws NotFoundException{
        Pacote pacote = service.findById(id).orElseThrow(()-> new NotFoundException("Pacote não encontrado."));
        return ResponseEntity.ok(pacote);
    }

    @PostMapping
    public ResponseEntity<Pacote> insert(@RequestBody PacoteDto pacoteDto) throws BadRequestException{
        Pacote pacote = converter.parseDtoToPacote(pacoteDto);
        return ResponseEntity.ok(service.inserir(pacote));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacote> alterar(@PathVariable("id") Long id, @RequestBody PacoteDto pacoteDto) throws BadRequestException{
        Pacote pacote= converter.parseDtoAndIdToPacote(pacoteDto,id);
        return ResponseEntity.ok(service.alterar(pacote));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        service.deletar(converter.parseIdToPacote(id));
    }



    
}
