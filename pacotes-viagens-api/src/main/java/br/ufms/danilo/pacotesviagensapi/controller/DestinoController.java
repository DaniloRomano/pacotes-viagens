package br.ufms.danilo.pacotesviagensapi.controller;

import br.ufms.danilo.pacotesviagensapi.entity.Destino;
import br.ufms.danilo.pacotesviagensapi.service.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/destino")
public class DestinoController {

    @Autowired
    private DestinoService service;

    @GetMapping
    public ResponseEntity<Page<Destino>> findAllByFilter(@PageableDefault Pageable pageable,String nome){
        return ResponseEntity.ok(service.findAllByFilter(pageable,nome));
    }
}
