package com.victor.armoryapi.repository;

import com.victor.armoryapi.model.ItemPOJO;

import java.util.List;
import java.util.Optional;

public interface ItemRepository<T, ID> {

    T save(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    void delete(T entity);

    List<T> findByName(String name);
}
