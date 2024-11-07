package com.ishells.options.service;

import com.ishells.options.model.AssetsData;
import com.ishells.options.repository.AssetsDataRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssetsDataServiceTest {

    @Mock
    private AssetsDataRepository assetsDataRepository;

    @InjectMocks
    private AssetsDataService assetsDataService;

    @Test
    public void testFindBySymbol() {
        String symbol = "AAPL";
        List<AssetsData> expectedData = new ArrayList<>();
        AssetsData assetsData = new AssetsData();
        assetsData.setId("1");
        assetsData.setSymbol("AAPL");
        assetsData.setName("Apple Inc.");
        assetsData.setAssetType("us_equity");
        assetsData.setExchange("NASDAQ");
        assetsData.setTradable(true);
        assetsData.setMarginable(true);
        assetsData.setShortable(true);
        assetsData.setEasyToBorrow(true);
        expectedData.add(assetsData);

        when(assetsDataRepository.findBySymbol(symbol)).thenReturn(expectedData);

        List<AssetsData> actualData = assetsDataService.findBySymbol(symbol);

        assertEquals(expectedData, actualData);
    }

    @Test
    public void testSaveAssetsData() {
        AssetsData assetsData = new AssetsData();
        assetsData.setId("1");
        assetsData.setSymbol("AAPL");
        assetsData.setName("Apple Inc.");
        assetsData.setAssetType("us_equity");
        assetsData.setExchange("NASDAQ");
        assetsData.setTradable(true);
        assetsData.setMarginable(true);
        assetsData.setShortable(true);
        assetsData.setEasyToBorrow(true);

        assetsDataService.saveAssetsData(assetsData);

        verify(assetsDataRepository).save(assetsData);
    }

    @Test
    public void testFindAssetsDataById() {
        String id = "1";
        AssetsData expectedData = new AssetsData();
        expectedData.setId(id);
        expectedData.setSymbol("AAPL");
        expectedData.setName("Apple Inc.");
        expectedData.setAssetType("us_equity");
        expectedData.setExchange("NASDAQ");
        expectedData.setTradable(true);
        expectedData.setMarginable(true);
        expectedData.setShortable(true);
        expectedData.setEasyToBorrow(true);

        when(assetsDataRepository.findById(id)).thenReturn(Optional.of(expectedData));

        AssetsData actualData = assetsDataService.findAssetsDataById(id);

        assertEquals(expectedData, actualData);
    }
}
