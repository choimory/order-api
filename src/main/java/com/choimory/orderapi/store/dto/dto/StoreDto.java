package com.choimory.orderapi.store.dto.dto;

import com.choimory.orderapi.item.dto.dto.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StoreDto {
    private Long id;
    private String name;
    private String description;
    private List<ItemDto> items;
}
