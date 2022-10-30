package com.choimory.orderapi.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@Getter
public enum OrderDefaultSort {
    FIND_ORDERS("id", Sort.Direction.ASC);

    private final String property;
    private final Sort.Direction direction;
}
