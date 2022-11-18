package br.ufms.danilo.pacotesviagensapi.assembler.destino;

import br.ufms.danilo.pacotesviagensapi.controller.DestinoController;
import br.ufms.danilo.pacotesviagensapi.entity.Destino;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DestinoRepresentationModelAssembler implements SimpleRepresentationModelAssembler<Destino> {
    @Override
    public void addLinks(EntityModel<Destino> resource) {

    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Destino>> resources) {
        Pageable pageable = PageRequest.of(0, 10);
        resources.add(linkTo(methodOn(DestinoController.class).findAllByFilter(pageable, "")).withSelfRel());
    }
}
