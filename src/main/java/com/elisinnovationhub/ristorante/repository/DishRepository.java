package com.elisinnovationhub.ristorante.repository;

import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<DishEntity, Long> {
    List<DishEntity> findByAvailableTrue();
}
