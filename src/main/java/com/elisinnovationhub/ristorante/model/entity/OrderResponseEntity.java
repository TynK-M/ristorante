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
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "order_request_id", unique = true)
    private OrderRequestEntity orderRequest;

    @ManyToMany
    @JoinTable(
            name = "order_response_dishes",
            joinColumns = @JoinColumn(name = "order_response_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<DishEntity> dishes;

    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;

    @Column(name = "with_reservation")
    private boolean withReservation;

    @Column(name = "participants")
    private Integer participants;
}
