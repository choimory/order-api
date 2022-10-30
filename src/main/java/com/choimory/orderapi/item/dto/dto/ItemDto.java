package com.choimory.orderapi.item.dto.dto;

import com.choimory.orderapi.item.entity.Item;
import com.choimory.orderapi.item.entity.ItemImage;
import com.choimory.orderapi.item.enums.ItemImageType;
import com.choimory.orderapi.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private List<ItemImageDto> images;
    private StoreDto store;

    public static ItemDto toDto(Item item){
        return item == null
                ? null
                : ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .price(item.getPrice())
                .images(item.getImages() == null
                        ? null
                        : item.getImages().stream()
                        .map(ItemImageDto::toDto)
                        .collect(Collectors.toUnmodifiableList()))
                .store(StoreDto.toDto(item.getStore()))
                .build();
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class ItemImageDto{
        private Long id;
        private ItemImageType type;
        private String url;
        private String name;
        private Long size;

        public static ItemImageDto toDto(ItemImage itemImage){
            return itemImage == null
                    ? null
                    : ItemImageDto.builder()
                    .id(itemImage.getId())
                    .type(itemImage.getType())
                    .url(itemImage.getUrl())
                    .name(itemImage.getName())
                    .size(itemImage.getSize())
                    .build();
        }
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class StoreDto{
        private Long id;
        private String name;
        private String description;

        public static StoreDto toDto(Store store){
            return store == null
                    ? null
                    : StoreDto.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .description(store.getDescription())
                    .build();
        }
    }
}
