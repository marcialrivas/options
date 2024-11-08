package com.ishells.options.model;

import lombok.Data;
@Data
public class AlpacaAsset {

    private String id;
    private String symbol;
    private String name;
    private String exchange;
    private String status;
    private boolean tradable;
    private boolean marginable;
    private boolean shortable;
    private boolean easyToBorrow;
    private double fractionalShareSize;
}
