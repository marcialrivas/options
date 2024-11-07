package com.ishells.options.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "assets")
@Data
public class AssetsData {
    @Id
    private String id;
    private String symbol;
    private String name;
    private String exchange;
    private String assetType;
    private boolean tradable;
    private boolean marginable;
    private boolean shortable;
    private boolean easyToBorrow;
}