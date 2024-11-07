package com.ishells.options.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.ishells.options.service.StockMarketDataService;
import com.ishells.options.model.StockMarketData;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class StockMarketDataController {

    @Autowired
    private final StockMarketDataService stockMarketDataService;

    public StockMarketDataController(StockMarketDataService stockMarketDataService) {
        this.stockMarketDataService = stockMarketDataService;
    }

    @GetMapping("/stockmarketdata/{symbol}")
    public CollectionModel<EntityModel<StockMarketData>> getStockMarketData(@PathVariable String symbol) {
        List<EntityModel<StockMarketData>> stockMarketData = stockMarketDataService.getStockMarketData(symbol).stream()
                .map(data -> EntityModel.of(data,
                        linkTo(methodOn(StockMarketDataController.class).getStockMarketData(symbol)).withSelfRel()))
                .collect(Collectors.toList());

        return CollectionModel.of(stockMarketData, 
                linkTo(methodOn(StockMarketDataController.class).getStockMarketData(symbol)).withSelfRel());
    }
}