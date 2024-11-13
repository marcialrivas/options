package com.ishells.options.service;

import java.util.List;

import com.ishells.options.model.AlpacaAsset;
import com.ishells.options.model.AlpacaPosition;

public interface AlpacaService {
    List<AlpacaAsset> getAssets();
    List<AlpacaPosition> getOpenPositions();
}
