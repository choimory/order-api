package com.choimory.orderapi.order.controller;

import com.choimory.orderapi.order.enums.OrderStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;


    @Test
    void findOrders() throws Exception {
        /*given*/
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String page = "1";
        String size = "5";
        String sort = "id:asc, createdAt:asc";
        params.add("page", page);
        params.add("size", size);
        params.add("sort", sort);

        /*when*/
        ResultActions when = mockMvc.perform(get("/api/orders")
                .accept(APPLICATION_JSON_UTF8)
                .params(params))
                .andDo(print());

        /*then*/
        when.andExpect(status().isOk())
                .andExpect(jsonPath("pagination.page").value(page))
                .andExpect(jsonPath("pagination.size").value(size))
                .andExpect(jsonPath("orders").hasJsonPath());

    }

    @ParameterizedTest
    @MethodSource("sourceForFindOrder")
    void findOrder(HttpStatus httpStatus, Long orderId) throws Exception {
        /*when*/
        ResultActions when = mockMvc.perform(MockMvcRequestBuilders.get("/api/orders/{id}", orderId)
                .accept(APPLICATION_JSON_UTF8))
                .andDo(print());

        /*then*/
        switch (httpStatus == null ? HttpStatus.OK : httpStatus){
            case OK:
                when.andExpect(status().isOk())
                        .andExpect(jsonPath("order.id" ).value(orderId));
                break;
            case NOT_FOUND:
                when.andExpect(status().isNotFound())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data").value(httpStatus.getReasonPhrase()));
                break;
            case BAD_REQUEST:
                when.andExpect(status().isBadRequest())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data").isArray())
                        .andExpect(jsonPath("data").isNotEmpty());
                break;
        }
    }

    @ParameterizedTest
    @MethodSource("sourceForAcceptOrder")
    void acceptOrder(HttpStatus httpStatus, Long orderId) throws Exception {
        /*when*/
        ResultActions when = mockMvc.perform(patch("/api/orders/{orderId}/accept", orderId)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print());

        /*then*/
        switch (httpStatus == null ? HttpStatus.OK : httpStatus){
            case OK:
                when.andExpect(status().isOk())
                        .andExpect(jsonPath("acceptedOrder.id" ).value(orderId))
                        .andExpect(jsonPath("acceptedOrder.status").value(OrderStatus.ACCEPT.name()));
                break;
            case NOT_FOUND:
                when.andExpect(status().isNotFound())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data").value(httpStatus.getReasonPhrase()));
                break;
            case BAD_REQUEST:
                when.andExpect(status().isBadRequest())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data[0].rejectedValue").value(orderId));
                break;
        }
    }

    @ParameterizedTest
    @MethodSource("sourceForCompleteOrder")
    void completeOrder(HttpStatus httpStatus, Long orderId) throws Exception {
        /*when*/
        ResultActions when = mockMvc.perform(patch("/api/orders/{orderId}/complete", orderId)
                .accept(APPLICATION_JSON_UTF8)
                .contentType(APPLICATION_JSON_UTF8))
                .andDo(print());

        /*then*/
        switch (httpStatus == null ? HttpStatus.OK : httpStatus){
            case OK:
                when.andExpect(status().isOk())
                        .andExpect(jsonPath("completedOrder.id" ).value(orderId))
                        .andExpect(jsonPath("completedOrder.status").value(OrderStatus.COMPLETE.name()));
                break;
            case NOT_FOUND:
                when.andExpect(status().isNotFound())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data").value(httpStatus.getReasonPhrase()));
                break;
            case BAD_REQUEST:
                when.andExpect(status().isBadRequest())
                        .andExpect(jsonPath("status").value(httpStatus.value()))
                        .andExpect(jsonPath("message").value(httpStatus.getReasonPhrase()))
                        .andExpect(jsonPath("data").isArray())
                        .andExpect(jsonPath("data").isNotEmpty());
                break;
        }
    }

    static Stream<Arguments> sourceForFindOrder(){
        return Stream.<Arguments>builder()
                //200
                .add(Arguments.of(HttpStatus.OK, 1L))
                //404
                .add(Arguments.of(HttpStatus.NOT_FOUND, 123L))
                //400
                .add(Arguments.of(HttpStatus.BAD_REQUEST, -1L))
                .build();
    }

    static Stream<Arguments> sourceForAcceptOrder(){
        return Stream.<Arguments>builder()
                //200
                .add(Arguments.of(HttpStatus.OK, 1L))
                //404
                .add(Arguments.of(HttpStatus.NOT_FOUND, 123L))
                //400
                .add(Arguments.of(HttpStatus.BAD_REQUEST, -1L))
                .build();
    }

    static Stream<Arguments> sourceForCompleteOrder(){
        return Stream.<Arguments>builder()
                //200
                .add(Arguments.of(HttpStatus.OK, 1L))
                //404
                .add(Arguments.of(HttpStatus.NOT_FOUND, 123L))
                //400
                .add(Arguments.of(HttpStatus.BAD_REQUEST, -1L))
                .build();
    }
}