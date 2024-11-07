package com.ishells.options.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ishells.options.model.AssetsData;

@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")

public interface AssetsDataRepository extends MongoRepository<AssetsData, String> {
}
