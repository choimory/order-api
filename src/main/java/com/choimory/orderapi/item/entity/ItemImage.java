package com.choimory.orderapi.item.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.enums.ItemImageType;

import javax.persistence.*;

@Entity
public class ItemImage extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ItemImageType type;
    private String url;
    private String name;
    private Long size;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
