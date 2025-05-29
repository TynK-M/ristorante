package com.elisinnovationhub.ristorante.mapper.impl;

import com.elisinnovationhub.ristorante.mapper.OrderResponseMapper;
import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;

public class OrderResponseMapperImpl implements OrderResponseMapper {


    @Override
    public OrderResponseDTO toOrderResponseDTO(OrderResponseEntity entity) {
        if (entity == null) {
            return null;
        }

        OrderResponseDTO dto = new OrderResponseDTO();

        dto.setOrderId(entity.getOrderId());
        dto.setTotal(entity.getTotal());
        dto.setDishes(entity.getDishes());
        dto.setParticipants(entity.getParticipants());
        dto.setDeliveryType(entity.getDeliveryType());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setWithReservation(entity.isWithReservation());

        return dto;
    }
}
