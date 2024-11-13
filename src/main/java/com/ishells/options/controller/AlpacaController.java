package com.ishells.options.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ishells.options.service.AlpacaService;
import com.ishells.options.model.AlpacaAsset;
import com.ishells.options.model.AlpacaPosition;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class AlpacaController {

    @Autowired
    private final AlpacaService alpacaService;

    public AlpacaController(AlpacaService alpacaService) {
        this.alpacaService = alpacaService;
    }

    @GetMapping("/alpaca/assets")
    public CollectionModel<EntityModel<AlpacaAsset>> getAlpacaAsset() {
        List<EntityModel<AlpacaAsset>> alpacaAssetsList = alpacaService.getAssets().stream()
                .map(data -> EntityModel.of(data,
                        linkTo(methodOn(AlpacaController.class).getAlpacaAsset()).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(alpacaAssetsList, 
                linkTo(methodOn(AlpacaController.class).getAlpacaAsset()).withSelfRel());
    }

    @GetMapping("/alpaca/positions")
    public CollectionModel<EntityModel<AlpacaPosition>> getOpenPositions() {
        List<EntityModel<AlpacaPosition>> alpacaPositionsList = alpacaService.getOpenPositions().stream()
                .map(data -> EntityModel.of(data,
                        linkTo(methodOn(AlpacaController.class).getOpenPositions()).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(alpacaPositionsList, 
                linkTo(methodOn(AlpacaController.class).getOpenPositions()).withSelfRel());
    }
}