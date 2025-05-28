package com.elisinnovationhub.ristorante.model.entity;

import com.elisinnovationhub.ristorante.model.en.DeliveryType;
import jakarta.persistence.*;
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
@Entity
@Table(name = "order_response")
public class OrderResponseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @ElementCollection
    @CollectionTable(name = "dish_names", joinColumns = @JoinColumn(name = "order_response_id"))
    @Column(name = "dish_name", nullable = false)
    private List<String> dishes;

    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type", nullable = false)
    private DeliveryType deliveryType;

    @Column(name = "with_reservation", nullable = false)
    private boolean withReservation;

    @Column(name = "participants")
    private Integer participants;
}
