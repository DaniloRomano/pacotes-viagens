package br.ufms.danilo.pacotesviagensapi.controller;

import br.ufms.danilo.pacotesviagensapi.dto.ViagemDto;
import br.ufms.danilo.pacotesviagensapi.exceptions.BadRequestException;
import br.ufms.danilo.pacotesviagensapi.models.Viajante;
import br.ufms.danilo.pacotesviagensapi.service.FacadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufms.danilo.pacotesviagensapi.converter.ViagemConverter;
import br.ufms.danilo.pacotesviagensapi.exceptions.NotFoundException;
import br.ufms.danilo.pacotesviagensapi.models.Viagem;
import br.ufms.danilo.pacotesviagensapi.service.ViagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/v1/viagem")
public class ViagemController {
    
    @Autowired
    private ViagemService service;

    @Autowired
    private FacadeService facadeService;

    @Autowired
    private ViagemConverter converter;

    @GetMapping
    public ResponseEntity<Page<Viagem>> findAllByFilter(Map<String, String> viagemFiltros, Pageable pageable) {
        return ResponseEntity.ok(service.findAllByFilter(converter.parseMapToViagem(viagemFiltros),pageable));
    }

    @GetMapping("/{id}/")
    public ResponseEntity<Viagem> findById(@PathVariable("id") Long id) throws NotFoundException{
        return ResponseEntity.ok(service.findById(id).orElseThrow(
            ()-> new NotFoundException("Viagem não encontrada.")
        ));
    }

    @PostMapping
    public ResponseEntity<Viagem> inserir(@RequestBody ViagemDto viagemDto) throws BadRequestException {
        return ResponseEntity.ok(service.inserir(converter.parseDtoToViagem(viagemDto)));
    }

    @PutMapping("/{id}/cancelar")
    public void cancelar(@PathVariable("id") Long id) throws Exception{
        service.cancelarViagem(id);
    }

    @GetMapping("/{id}/viajantes")
    public ResponseEntity<List<Viajante>> getViajantesDaViagem(@PathVariable("id") Long idViagem){
        return ResponseEntity.ok(facadeService.buscarViajantesPorViagemId(idViagem));
    }
    
}
