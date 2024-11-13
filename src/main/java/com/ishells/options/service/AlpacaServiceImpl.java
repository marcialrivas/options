package com.ishells.options.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ishells.options.configuration.AlpacaConfig;
import com.ishells.options.model.AlpacaAsset;
import com.ishells.options.model.AlpacaPosition;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlpacaServiceImpl implements AlpacaService {

    private final WebClient webClient;
    private final AlpacaConfig alpacaConfig;

    public AlpacaServiceImpl(WebClient.Builder webClientBuilder, AlpacaConfig alpacaConfig) {
        this.alpacaConfig = alpacaConfig;
        this.webClient = webClientBuilder.build();
    }

    @Override
    public List<AlpacaAsset> getAssets() {
        return webClient.get()
                .uri(alpacaConfig.getBaseUrl() + "/v2/assets")
                .header("APCA-API-KEY-ID", alpacaConfig.getApiKey())
                .header("APCA-API-SECRET-KEY", alpacaConfig.getSecretKey())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)                 
                .retrieve()
                .bodyToFlux(AlpacaAsset.class)
                .collectList()
                .block()
                .stream()
                .filter(asset -> 
                    asset.getStatus().equals("active") &&
                    asset.isTradable() &&
                    asset.getExchange().equals("NASDAQ") &&
                    asset.isMarginable()
                )
                .filter(asset -> asset.isFractionable())
                .collect(Collectors.toList());
    }

    @Override
    public List<AlpacaPosition> getOpenPositions() {
        return webClient.get()
                .uri(alpacaConfig.getBaseUrl() + "/v2/positions")
                .header("APCA-API-KEY-ID", alpacaConfig.getApiKey())
                .header("APCA-API-SECRET-KEY", alpacaConfig.getSecretKey())
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)                 
                .retrieve()
                .bodyToFlux(AlpacaPosition.class)
                .collectList()
                .block();
    }
}
