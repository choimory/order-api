package com.choimory.orderapi.store.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.entity.Item;
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
public class Store extends CommonDateTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

    @Builder(toBuilder = true)
    public Store(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, String name, String description, List<Item> items) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.name = name;
        this.description = description;
        this.items = items;
    }
}
