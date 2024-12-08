package com.victor.armoryapi.model;

import lombok.Data;

@Data
public class ItemDTO {
    private String id;
    private String name;
    private String caliber;
    private int effectiveRange;
    private int maximumRange;
    private int rateOfFireire;
    private int practicalRateOfFire;
    private int magazineCapacity;
    private  String[] fireModes;
    private int serviceYear;
    private String url;
}
