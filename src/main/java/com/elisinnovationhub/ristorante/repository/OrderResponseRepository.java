package com.elisinnovationhub.ristorante.repository;

import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderResponseRepository extends JpaRepository<OrderResponseEntity, Long> {
}
