package com.victor.armoryapi.service;

import com.victor.armoryapi.model.ItemDTO;
import com.victor.armoryapi.model.ItemPOJO;
import com.victor.armoryapi.repository.DefaultRepositoryFactory;
import com.victor.armoryapi.repository.ItemRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(DefaultRepositoryFactory repositoryFactory) {
        if (repositoryFactory != null) {
            this.itemRepository = repositoryFactory.getItemRepository();
        } else {
            throw new IllegalArgumentException("RepositoryFactory must not be null");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemPOJO> pojos = (List<ItemPOJO>) itemRepository.findAll();
        return pojos.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ItemDTO getItemById(String id) throws Throwable {
        ItemPOJO pojo = (ItemPOJO) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return mapToDTO(pojo);
    }

    @Override
    public List<ItemDTO> findByName(String name) {
        List<ItemPOJO> pojos = (List<ItemPOJO>) itemRepository.findByName(name);
        return pojos.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        ItemPOJO savedItem = (ItemPOJO) itemRepository.save(mapToEntity(itemDTO));
        return mapToDTO(savedItem);
    }

    @Override
    public void delete(int id) throws Throwable {
        ItemPOJO pojoToDelete = (ItemPOJO) itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(pojoToDelete);
    }

    private ItemDTO mapToDTO(ItemPOJO itemPOJO) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemPOJO.getId().toString());
        itemDTO.setName(itemPOJO.getName());
        itemDTO.setCaliber(itemPOJO.getCaliber());
        itemDTO.setEffectiveRange(itemPOJO.getEffectiveRange());
        itemDTO.setMaximumRange(itemPOJO.getMaximumRange());
        itemDTO.setRateOfFireire(itemPOJO.getRateOfFireire());
        itemDTO.setPracticalRateOfFire(itemPOJO.getPracticalRateOfFire());
        itemDTO.setMagazineCapacity(itemPOJO.getMagazineCapacity());
        itemDTO.setFireModes(itemPOJO.getFireModes());
        itemDTO.setServiceYear(itemPOJO.getServiceYear());
        itemDTO.setUrl(itemPOJO.getUrl());
        return itemDTO;
    }

    private ItemPOJO mapToEntity(ItemDTO itemDTO) {
        ItemPOJO itemPOJO = new ItemPOJO();
        itemPOJO.setId(new ObjectId(itemDTO.getId()));
        itemPOJO.setName(itemDTO.getName());
        itemPOJO.setCaliber(itemDTO.getCaliber());
        itemPOJO.setEffectiveRange(itemDTO.getEffectiveRange());
        itemPOJO.setMaximumRange(itemDTO.getMaximumRange());
        itemPOJO.setRateOfFireire(itemDTO.getRateOfFireire());
        itemPOJO.setPracticalRateOfFire(itemDTO.getPracticalRateOfFire());
        itemPOJO.setMagazineCapacity(itemDTO.getMagazineCapacity());
        itemPOJO.setFireModes(itemDTO.getFireModes());
        itemPOJO.setServiceYear(itemDTO.getServiceYear());
        itemPOJO.setUrl(itemDTO.getUrl());
        return itemPOJO;
    }
}
