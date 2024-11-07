package com.ishells.options.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ishells.options.repository.StockMarketDataRepository;
import com.ishells.options.model.StockMarketData;

@Service
public class StockMarketDataService {

    @Autowired
    private StockMarketDataRepository repository;

    public void saveStockMarketData(StockMarketData data) {
        repository.save(data);
    }

    public StockMarketData findStockMarketDataById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<StockMarketData> getStockMarketData(String symbol) {
        // Add any business logic here if needed (e.g., data validation, transformation)
        return repository.findBySymbol(symbol.toUpperCase()) ; 
    }
}