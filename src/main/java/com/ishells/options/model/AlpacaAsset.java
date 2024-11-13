package com.ishells.options.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class AlpacaAsset {

    private String id;
    @JsonAlias("class")
    private String assetClass;
    private String exchange;
    private String symbol;
    private String name;
    private String status;
    private boolean tradable;
    private boolean marginable;
    @JsonAlias("maintenance_margin_requirement")
    private double maintenanceMarginRequirement;
    @JsonAlias("margin_requirement_long")
    private double marginRequirementLong;
    @JsonAlias("margin_requirement_short")
    private double marginRequirementShort;
    private boolean shortable;
    @JsonAlias("easy_to_borrow")
    private boolean easyToBorrow;
    private boolean fractionable;
}
