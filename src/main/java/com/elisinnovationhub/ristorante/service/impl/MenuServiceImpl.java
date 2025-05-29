package com.elisinnovationhub.ristorante.service.impl;

import com.elisinnovationhub.ristorante.mapper.DishMapper;
import com.elisinnovationhub.ristorante.mapper.impl.DishMapperImpl;
import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;
import com.elisinnovationhub.ristorante.repository.DishRepository;
import com.elisinnovationhub.ristorante.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public MenuServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
        this.dishMapper = new DishMapperImpl(); // manually instantiated
    }

    @Override
    public List<DishDTO> getTheMenu() {
        List<DishEntity> dishes = dishRepository.findByAvailableTrue();
        return dishes.stream()
                .map(dishMapper::toDishDTO)
                .collect(Collectors.toList());
    }
}