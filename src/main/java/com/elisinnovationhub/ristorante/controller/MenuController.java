package com.elisinnovationhub.ristorante.controller;

import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @Operation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Piatti trovati"),
    })
    @GetMapping
    public ResponseEntity<List<DishDTO>> getTheMenu() {
        List<DishDTO> dishes = menuService.getTheMenu();
        return ResponseEntity.ok(dishes);
    }

}
