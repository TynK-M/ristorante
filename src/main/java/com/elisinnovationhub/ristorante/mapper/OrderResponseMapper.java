package com.elisinnovationhub.ristorante.mapper;

import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {
    // DTO <-> Entity
    OrderResponseDTO toOrderResponseDTO(OrderResponseEntity orderResponseEntity);
    OrderResponseEntity toOrderResponseEntity(OrderResponseDTO orderResponseDTO);
}
