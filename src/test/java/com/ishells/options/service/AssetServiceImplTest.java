package com.ishells.options.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ishells.options.model.AlpacaAsset;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AssetServiceImplTest {

    @Autowired
    private AlpacaService alpacaService;

    @Test
    public void testGetAssets() {
        List<AlpacaAsset> assets = alpacaService.getAssets();
        assertNotNull(assets);
        // Add more assertions to validate the response
    }
}
