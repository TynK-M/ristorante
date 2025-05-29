package com.elisinnovationhub.ristorante.service;

import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuService {

    List<DishDTO> getTheMenu();
}
