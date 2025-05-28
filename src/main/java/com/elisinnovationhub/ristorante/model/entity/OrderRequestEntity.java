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
    @Column(nullable = false, updatable = false)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "dish_ids", joinColumns = @JoinColumn(name = "order_request_id"))
    @Column(name = "dish_id", nullable = false)
    private List<Long> dishIds;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type", nullable = false)
    private DeliveryType deliveryType;

    @Column(name = "with_reservation", nullable = false)
    private boolean withReservation;

    @Column(name = "participants")
    private Integer participants; // obbligatorio solo per IN_HOUSE

}
