package com.ishells.options.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ishells.options.model.StockMarketData;

public interface StockMarketDataRepository extends MongoRepository<StockMarketData, String> {
}