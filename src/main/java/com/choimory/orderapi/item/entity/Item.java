package com.choimory.orderapi.item.entity;

import com.choimory.orderapi.store.entity.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long price;
    @OneToMany(fetch = FetchType.LAZY)
    private List<ItemImage> images = new ArrayList();
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
