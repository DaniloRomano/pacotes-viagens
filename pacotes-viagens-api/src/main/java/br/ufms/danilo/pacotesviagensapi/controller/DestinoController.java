package br.ufms.danilo.pacotesviagensapi.controller;

import br.ufms.danilo.pacotesviagensapi.assembler.destino.DestinoRepresentationModelAssembler;
import br.ufms.danilo.pacotesviagensapi.converter.DestinoConverter;
import br.ufms.danilo.pacotesviagensapi.dto.DestinoDto;
import br.ufms.danilo.pacotesviagensapi.models.Destino;
import br.ufms.danilo.pacotesviagensapi.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/destino")
public class DestinoController {

    @Autowired
    private DestinoService service;

    @Autowired
    private DestinoConverter converter;

    @Autowired
    private DestinoRepresentationModelAssembler destinoRepresentationModelAssembler;

    final PagedResourcesAssembler pagedResourcesAssembler;

    public DestinoController(PagedResourcesAssembler pagedResourcesAssembler) {
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping
    public ResponseEntity<Page<Destino>> findAllByFilter(@PageableDefault Pageable pageable, String nome){
        return ResponseEntity.ok(service.findAllByFilter(pageable,nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Destino> insertNew(@RequestBody DestinoDto destinoDto){
        return ResponseEntity.ok(service.insertNew(converter.parseDtoToDestino(destinoDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Destino> alterar(@PathVariable("id") Long idDestino,@RequestBody DestinoDto destinoDto){
        destinoDto.setId(idDestino);
        return ResponseEntity.ok(service.alterar(converter.parseDtoToDestino(destinoDto)));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long idDestino){
        service.deletar(idDestino);
    }
}
