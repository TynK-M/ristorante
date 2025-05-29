package com.elisinnovationhub.ristorante.mapper.impl;

import com.elisinnovationhub.ristorante.mapper.DishMapper;
import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;

public class DishMapperImpl implements DishMapper {
    @Override
    public DishDTO toDishDTO(DishEntity dishEntity) {
        if (dishEntity == null) {
            return null;
        }

        DishDTO dishDTO = new DishDTO();

        dishDTO.setId(dishEntity.getId());
        dishDTO.setName(dishEntity.getName());
        dishDTO.setPrice(dishEntity.getPrice());
        dishDTO.setAvailable(dishEntity.isAvailable());
        dishDTO.setDescription(dishEntity.getDescription());

        return dishDTO;
    }
}
