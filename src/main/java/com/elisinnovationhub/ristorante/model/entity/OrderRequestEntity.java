package com.elisinnovationhub.ristorante.model.entity;

import com.elisinnovationhub.ristorante.model.en.DeliveryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_request")
public class OrderRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "order_request_dishes",
            joinColumns = @JoinColumn(name = "order_request_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<DishEntity> dishes;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;

    @Column(name = "with_reservation")
    private boolean withReservation;

    @Column(name = "participants")
    private Integer participants; // obbligatorio solo per IN_HOUSE

    @OneToOne(mappedBy = "orderRequest", cascade = CascadeType.ALL)
    private OrderResponseEntity response;

}
