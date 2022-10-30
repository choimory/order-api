package com.choimory.orderapi.item.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.store.entity.Store;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Item extends CommonDateTimeEntity {
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

    @Builder(toBuilder = true)
    public Item(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, String name, String description, Long price, List<ItemImage> images, Store store) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.images = images;
        this.store = store;
    }
}
