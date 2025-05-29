package com.elisinnovationhub.ristorante.mapper;

import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;
import org.mapstruct.Mapper;

public interface DishMapper {
    // DTO <-> Entity
    DishDTO toDishDTO(DishEntity dishEntity);
}
