package com.ishells.options.repository;

import com.ishells.options.model.StockMarketData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class StockMarketDataRepositoryTest {

    @Mock
    private StockMarketDataRepository stockMarketDataRepository;

    @Test
    public void testFindBySymbol() {
        String symbol = "AAPL";
        List<StockMarketData> expectedData = new ArrayList<>();
        StockMarketData stockMarketData = new StockMarketData();
        stockMarketData.setId("1");
        stockMarketData.setSymbol("AAPL");
        stockMarketData.setOpen(150.0);
        stockMarketData.setHigh(155.0);
        stockMarketData.setLow(148.0);
        stockMarketData.setClose(152.0);
        stockMarketData.setVolume(1000000L);
        stockMarketData.setDate("2021-09-01");
        expectedData.add(stockMarketData);

        // Populate expectedData with sample StockMarketData for AAPL

        when(stockMarketDataRepository.findBySymbol(symbol)).thenReturn(expectedData);

        List<StockMarketData> actualData = stockMarketDataRepository.findBySymbol(symbol);

        assertEquals(expectedData, actualData);
    }
}
