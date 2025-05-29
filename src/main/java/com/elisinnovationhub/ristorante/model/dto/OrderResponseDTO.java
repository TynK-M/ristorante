package com.elisinnovationhub.ristorante.model.dto;

import com.elisinnovationhub.ristorante.model.en.DeliveryType;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long orderId;
    private List<DishEntity> dishes;
    private BigDecimal total;
    private LocalDateTime createdAt;
    private DeliveryType deliveryType;
    private boolean withReservation;
    private Integer participants;
}
