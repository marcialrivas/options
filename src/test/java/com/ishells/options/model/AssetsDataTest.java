package com.ishells.options.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssetsDataTest {

    @Test
    public void testGettersAndSetters() {
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

        Assertions.assertEquals("1", assetsData.getId());
        Assertions.assertEquals("TSLA", assetsData.getSymbol());
        Assertions.assertEquals("Tesla, Inc. Common Stock", assetsData.getName());
        Assertions.assertEquals("us_equity", assetsData.getAssetType());
        Assertions.assertEquals("NASDAQ", assetsData.getExchange());
        Assertions.assertEquals(true, assetsData.isTradable());
        Assertions.assertEquals(true, assetsData.isMarginable());
        Assertions.assertEquals(true, assetsData.isShortable());
        Assertions.assertEquals(true, assetsData.isEasyToBorrow());
        
    }

}
