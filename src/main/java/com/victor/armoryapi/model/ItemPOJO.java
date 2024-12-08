package com.victor.armoryapi.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("items")
public class ItemPOJO {
    @Id
    private ObjectId id;
    private String name;
    private String caliber;
    @Field("effective_range")
    private int effectiveRange;
    @Field("maximum_range")
    private int maximumRange;
    @Field("rate_of_fire")
    private int rateOfFireire;
    @Field("practical_rate_of_fire")
    private int practicalRateOfFire;
    @Field("magazine_capacity")
    private int magazineCapacity;
    @Field("fire_modes")
    private  String[] fireModes;
    @Field("service_year")
    private int serviceYear;
    private String url;

}
