package com.elisinnovationhub.ristorante.repository;

import com.elisinnovationhub.ristorante.model.entity.OrderRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRequestRepository extends JpaRepository<OrderRequestEntity, Long> {
}
