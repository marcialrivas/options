package com.ishells.options.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "alpaca")
public class AlpacaConfig {

    private String apiKey;
    private String secretKey;
    private String baseUrl;

}