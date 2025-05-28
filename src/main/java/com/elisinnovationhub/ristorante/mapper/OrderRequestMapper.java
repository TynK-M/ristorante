package com.elisinnovationhub.ristorante.mapper;

import com.elisinnovationhub.ristorante.model.dto.OrderRequestDTO;
import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.model.entity.OrderRequestEntity;
import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {
    // DTO <-> Entity
    OrderRequestDTO toOrderRequestDTO(OrderRequestEntity orderRequestEntity);
    OrderRequestEntity toOrderRequestEntity(OrderRequestDTO orderRequestDTO);
}