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

import com.ishells.options.model.AssetsData;
import com.ishells.options.repository.AssetsDataRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class AssetsDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AssetsDataRepository assetsDataRepository;

    @Test
    public void testAllAssetsData() throws Exception {
        AssetsData assetsData1 = new AssetsData();
        assetsData1.setId("1");
        assetsData1.setSymbol("AAPL");

        AssetsData assetData2 = new AssetsData();
        assetData2.setId("2");
        assetData2.setSymbol("TSLA");

        assetsDataRepository.save(assetsData1);
        assetsDataRepository.save(assetData2);

        mockMvc.perform(get("/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.assets.length()",greaterThan(1)));

    }

    @Test
    public void testFindBySymbolAssetsData() throws Exception {
        AssetsData assetsData1 = new AssetsData();
        assetsData1.setId("1");
        assetsData1.setSymbol("AAPL");

        AssetsData assetData2 = new AssetsData();
        assetData2.setId("2");
        assetData2.setSymbol("TSLA");

        assetsDataRepository.save(assetsData1);
        assetsDataRepository.save(assetData2);

        mockMvc.perform(get("/assets/search/findBySymbol?symbol=AAPL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.assets.length()",greaterThan(0)));

    }
}
