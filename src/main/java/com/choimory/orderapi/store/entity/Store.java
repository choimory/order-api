package com.choimory.orderapi.store.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.entity.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();
}
