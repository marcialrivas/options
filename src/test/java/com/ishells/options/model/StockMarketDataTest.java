package com.ishells.options.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StockMarketDataTest {

    @Test
    public void testGettersAndSetters() {
        StockMarketData stockMarketData = new StockMarketData();
        stockMarketData.setId("1");
        stockMarketData.setSymbol("AAPL");
        stockMarketData.setOpen(150.0);
        stockMarketData.setHigh(155.0);
        stockMarketData.setLow(148.0);
        stockMarketData.setClose(152.0);
        stockMarketData.setVolume(1000000L);
        stockMarketData.setDate("2021-09-01");

        Assertions.assertEquals("1", stockMarketData.getId());
        Assertions.assertEquals("AAPL", stockMarketData.getSymbol());
        Assertions.assertEquals(150.0, stockMarketData.getOpen());
        Assertions.assertEquals(155.0, stockMarketData.getHigh());
        Assertions.assertEquals(148.0, stockMarketData.getLow());
        Assertions.assertEquals(152.0, stockMarketData.getClose());
        Assertions.assertEquals(1000000L, stockMarketData.getVolume());
        Assertions.assertEquals("2021-09-01", stockMarketData.getDate());
    }
}