package com.ishells.options.repository;

import com.ishells.options.model.AssetsData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class AssetsDataRepositoryTest {

    @Mock
    private AssetsDataRepository assetsDataRepository;

    @Test
    public void testFindBySymbol() {
        String symbol = "AAPL";
        List<AssetsData> expectedData = new ArrayList<>();
        AssetsData assetsData = new AssetsData();
        assetsData.setId("1");
        assetsData.setSymbol("TSLA");
        assetsData.setName("Tesla, Inc. Common Stock");
        assetsData.setAssetType("us_equity");
        assetsData.setExchange("NASDAQ");
        assetsData.setTradable(true);
        assetsData.setMarginable(true);
        assetsData.setShortable(true);
        assetsData.setEasyToBorrow(true);
        expectedData.add(assetsData);

        // Populate expectedData with sample StockMarketData for AAPL

        when(assetsDataRepository.findBySymbol(symbol)).thenReturn(expectedData);

        List<AssetsData> actualData = assetsDataRepository.findBySymbol(symbol);

        assertEquals(expectedData, actualData);
    }
}
