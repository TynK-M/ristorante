package com.elisinnovationhub.ristorante.model.dto;

import com.elisinnovationhub.ristorante.model.en.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private List<DishDTO> dishes;
    private DeliveryType deliveryType;
    private boolean withReservation;
    private Integer participants; // obbligatorio solo per IN_HOUSE
}