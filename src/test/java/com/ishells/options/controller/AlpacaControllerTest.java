package com.ishells.options.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
@AutoConfigureMockMvc
public class AlpacaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAssetsFromAlpaca() throws Exception {
        // Perform the request to the endpoint
        mockMvc.perform(get("/alpaca/assets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.alpacaAssets.length()", greaterThan(0))); // Assuming the response is a list of assets
    }

    @Test
    public void testGetOpenPositionsFromAlpaca() throws Exception {
        // Perform the request to the endpoint
        mockMvc.perform(get("/alpaca/positions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("_embedded.alpacaPositions.length()", greaterThan(0))); // Assuming the response is a list of positions
    }
}