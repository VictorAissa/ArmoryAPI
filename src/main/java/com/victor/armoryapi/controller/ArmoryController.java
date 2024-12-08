package com.victor.armoryapi.controller;

import com.victor.armoryapi.model.ItemDTO;
import com.victor.armoryapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArmoryController {
     private final ItemService itemService;

    @Autowired
    public ArmoryController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
}