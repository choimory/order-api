package com.choimory.orderapi.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    WAIT, ACCEPT, COMPLETE
}
