package com.elisinnovationhub.ristorante.service;

import com.elisinnovationhub.ristorante.model.dto.OrderRequestDTO;
import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {

    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO getOrderById(Long orderId);
    void deleteOrderById(Long orderId);
    OrderResponseDTO processOrder(OrderRequestDTO orderRequestDTO);
}
