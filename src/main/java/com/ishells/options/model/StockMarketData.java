package com.ishells.options.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "stockmarketdata")
@Data
public class StockMarketData {
    @Id
    private String id;
    private String symbol;
    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;
    private String date;
}