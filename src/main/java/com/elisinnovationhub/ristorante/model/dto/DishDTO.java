package com.elisinnovationhub.ristorante.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available;
}
