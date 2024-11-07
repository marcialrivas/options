package com.ishells.options.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Add this import
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Add this import
import static org.hamcrest.Matchers.greaterThan;

import com.ishells.options.model.StockMarketData;
import com.ishells.options.repository.StockMarketDataRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class StockMarketDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StockMarketDataRepository stockMarketDataRepository;

    @Test
    public void testAllAssetsData() throws Exception {
        StockMarketData stockMarketData1 = new StockMarketData();
        stockMarketData1.setId("1");
        stockMarketData1.setSymbol("AAPL");

        StockMarketData stockMarketData2 = new StockMarketData();
        stockMarketData2.setId("2");
        stockMarketData2.setSymbol("TSLA");

        stockMarketDataRepository.save(stockMarketData1);
        stockMarketDataRepository.save(stockMarketData2);

        mockMvc.perform(get("/stock-market-data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.stock-market-data.length()",greaterThan(1)));

    }

    @Test
    public void testFindBySymbolAssetsData() throws Exception {
        StockMarketData stockMarketData1 = new StockMarketData();
        stockMarketData1.setId("1");
        stockMarketData1.setSymbol("AAPL");

        StockMarketData stockMarketData2 = new StockMarketData();
        stockMarketData2.setId("2");
        stockMarketData2.setSymbol("TSLA");

        stockMarketDataRepository.save(stockMarketData1);
        stockMarketDataRepository.save(stockMarketData2);

        mockMvc.perform(get("/stock-market-data/search/findBySymbol?symbol=AAPL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.stock-market-data.length()",greaterThan(0)));

    }
}
