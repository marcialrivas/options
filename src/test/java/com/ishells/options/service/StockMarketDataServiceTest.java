package com.ishells.options.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ishells.options.model.StockMarketData;
import com.ishells.options.repository.StockMarketDataRepository;

@ExtendWith(MockitoExtension.class)
public class StockMarketDataServiceTest {

    @Mock
    private StockMarketDataRepository stockMarketDataRepository;

    @InjectMocks
    private StockMarketDataService stockMarketDataService;

    @Test
    public void testSaveStockMarketData() {
        StockMarketData stockMarketData = new StockMarketData();
        stockMarketData.setId("1");
        stockMarketData.setSymbol("AAPL");
        stockMarketData.setOpen(150.0);
        stockMarketData.setHigh(155.0);
        stockMarketData.setLow(148.0);
        stockMarketData.setClose(152.0);
        stockMarketData.setVolume(1000000L);
        stockMarketData.setDate("2021-09-01");
       
        stockMarketDataService.saveStockMarketData(stockMarketData);

        verify(stockMarketDataRepository).save(stockMarketData);
    }

    @Test
    public void testFindStockMarketDataById() {
        String id = "1";
        StockMarketData expectedData = new StockMarketData();
        expectedData.setId(id);
        expectedData.setSymbol("AAPL");
        expectedData.setOpen(150.0);
        expectedData.setHigh(155.0);
        expectedData.setLow(148.0);
        expectedData.setClose(152.0);
        expectedData.setVolume(1000000L);
        expectedData.setDate("2021-09-01");
        

        when(stockMarketDataRepository.findById(id)).thenReturn(Optional.of(expectedData));

        StockMarketData actualData = stockMarketDataService.findStockMarketDataById(id);

        assertEquals(expectedData, actualData);
    }

    @Test
    public void testFindBySymbol() {
        List<StockMarketData> expectedData = new ArrayList<>();
        String symbol = "AAPL";
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

        when(stockMarketDataRepository.findBySymbol(symbol)).thenReturn(expectedData);

        List<StockMarketData> actualData = stockMarketDataService.getStockMarketData(symbol);

        assertEquals(expectedData, actualData);
    }
}
