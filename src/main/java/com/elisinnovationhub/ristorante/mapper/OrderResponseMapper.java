package com.elisinnovationhub.ristorante.mapper;

import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;

public interface OrderResponseMapper {
    // DTO <-> Entity
    OrderResponseDTO toOrderResponseDTO(OrderResponseEntity orderResponseEntity);
}
