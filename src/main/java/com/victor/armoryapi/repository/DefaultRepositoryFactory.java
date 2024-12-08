package com.victor.armoryapi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultRepositoryFactory implements RepositoryFactory {
    private final MongoItemRepository mongoItemRepository;

    @Autowired
    public DefaultRepositoryFactory(MongoItemRepository mongoItemRepository) {
        this.mongoItemRepository = mongoItemRepository;
    }

    public ItemRepository getItemRepository() {
            return mongoItemRepository;
    }
}
