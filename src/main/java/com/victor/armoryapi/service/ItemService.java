package com.victor.armoryapi.service;

import com.victor.armoryapi.model.ItemDTO;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    public List<ItemDTO> getAllItems();

    public ItemDTO getItemById(String id) throws Throwable;

    public List<ItemDTO> findByName(String name);

    public ItemDTO save(ItemDTO itemDTO);

    public void delete(int id) throws Throwable;
}
