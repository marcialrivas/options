package com.ishells.options.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class AlpacaPosition {

    @JsonAlias("asset_id")
    private String assetId;
    private String symbol;
    private String exchange;
    @JsonAlias("asset_class")
    private String assetClass;
    @JsonAlias("asset_marginable")
    private boolean assetMarginable;
    @JsonAlias("qty")
    private double qty;
    @JsonAlias("avg_entry_price")
    private double avgEntryPrice;
    private String side;
    @JsonAlias("market_value")
    private double marketValue;
    @JsonAlias("cost_basis")
    private double costBasis;
    @JsonAlias("unrealized_pl")
    private double unrealizedPl;
    @JsonAlias("unrealized_plpc")
    private double unrealizedPlpc;
    @JsonAlias("unrealized_intraday_pl")
    private double unrealizedIntradayPl;
    @JsonAlias("unrealized_intraday_plpc")
    private double unrealizedIntradayPlpc;
    @JsonAlias("current_price")
    private double currentPrice;
    @JsonAlias("lastday_price")
    private double lastdayPrice;
    @JsonAlias("change_today")
    private double changeToday;
    @JsonAlias("qty_available")
    private double qtyAvailable;
}
