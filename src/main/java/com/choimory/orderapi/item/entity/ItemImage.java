package com.choimory.orderapi.item.entity;

import com.choimory.orderapi.common.entity.CommonDateTimeEntity;
import com.choimory.orderapi.item.enums.ItemImageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
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

    @Builder(toBuilder = true)
    public ItemImage(LocalDateTime createdAt, LocalDateTime modifiedAt, LocalDateTime deletedAt, Long id, ItemImageType type, String url, String name, Long size, Item item) {
        super(createdAt, modifiedAt, deletedAt);
        this.id = id;
        this.type = type;
        this.url = url;
        this.name = name;
        this.size = size;
        this.item = item;
    }
}
