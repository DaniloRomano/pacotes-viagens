package br.ufms.danilo.pacotesviagensapi.controller;

import br.ufms.danilo.pacotesviagensapi.converter.ViajanteConverter;
import br.ufms.danilo.pacotesviagensapi.dto.ViajanteDto;
import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.exceptions.InvalidDocumentException;
import br.ufms.danilo.pacotesviagensapi.models.Viajante;
import br.ufms.danilo.pacotesviagensapi.service.ViajanteService;
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

import java.util.Map;

@RestController
@RequestMapping("/v1/viajante")
public class ViajanteController {

    @Autowired
    private ViajanteService service;

    @Autowired
    private ViajanteConverter converter;

    @GetMapping
    public ResponseEntity<Page<Viajante>> findAllByFilter(@RequestParam Map<String, String> viajanteFiltros, Pageable pageable){
        return ResponseEntity.ok(service.findAllByFilter(converter.parseMapToViajante(viajanteFiltros),pageable));
    }


    @PostMapping
    public ResponseEntity<Viajante> inserir(@RequestBody ViajanteDto viajanteDto) throws BadRequestException, InvalidDocumentException {
        return ResponseEntity.ok(service.salvar(converter.parseDtoToViajante(viajanteDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viajante> alterar(@PathVariable("id") Long id, @RequestBody ViajanteDto viajanteDto) throws BadRequestException, InvalidDocumentException {
        return ResponseEntity.ok(service.salvar(converter.parseDtoAndIdToViajante(viajanteDto,id)));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") Long id){
        service.remover(converter.parseIdToViajante(id));
    }
    
}
