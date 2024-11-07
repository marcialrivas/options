package com.ishells.options.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ishells.options.model.StockMarketData;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stock-market-data", path = "stock-market-data")
public interface StockMarketDataRepository extends MongoRepository<StockMarketData, String> {

    List<StockMarketData> findBySymbol(String symbol);
}