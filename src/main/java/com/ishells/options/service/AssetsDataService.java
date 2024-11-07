package com.ishells.options.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ishells.options.repository.AssetsDataRepository;
import com.ishells.options.model.AssetsData;

@Service
public class AssetsDataService {

    @Autowired
    private AssetsDataRepository repository;

    public void saveAssetsData(AssetsData data) {
        repository.save(data);
    }

    public AssetsData findAssetsDataById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<AssetsData> findBySymbol(String symbol) {
        // Add any business logic here if needed (e.g., data validation, transformation)
        return repository.findBySymbol(symbol.toUpperCase());
    }
}