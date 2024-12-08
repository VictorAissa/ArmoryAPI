package com.victor.armoryapi.repository;

import com.victor.armoryapi.model.ItemPOJO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoItemRepository
        extends MongoRepository<ItemPOJO, String>, ItemRepository<ItemPOJO, String> {

    List<ItemPOJO> findByName(String name);
}
