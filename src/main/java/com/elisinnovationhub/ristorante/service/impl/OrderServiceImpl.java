package com.elisinnovationhub.ristorante.service.impl;

import com.elisinnovationhub.ristorante.exception.custom.*;
import com.elisinnovationhub.ristorante.mapper.OrderRequestMapper;
import com.elisinnovationhub.ristorante.mapper.OrderResponseMapper;
import com.elisinnovationhub.ristorante.mapper.OrderResponseMapperImpl;
import com.elisinnovationhub.ristorante.model.dto.DishDTO;
import com.elisinnovationhub.ristorante.model.dto.OrderRequestDTO;
import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.model.en.DeliveryType;
import com.elisinnovationhub.ristorante.model.entity.DishEntity;
import com.elisinnovationhub.ristorante.model.entity.OrderRequestEntity;
import com.elisinnovationhub.ristorante.model.entity.OrderResponseEntity;
import com.elisinnovationhub.ristorante.repository.DishRepository;
import com.elisinnovationhub.ristorante.repository.OrderRequestRepository;
import com.elisinnovationhub.ristorante.repository.OrderResponseRepository;
import com.elisinnovationhub.ristorante.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final DishRepository dishRepository;
    private final OrderRequestRepository orderRequestRepository;
    private final OrderRequestMapper orderRequestMapper;
    private final OrderResponseRepository orderResponseRepository;
    private final OrderResponseMapper orderResponseMapper;

    @Autowired
    public OrderServiceImpl(DishRepository dishRepository,
                            OrderRequestRepository orderRequestRepository,
                            OrderRequestMapper orderRequestMapper,
                            OrderResponseRepository orderResponseRepository,
                            OrderResponseMapper orderResponseMapper
    ) {
        this.dishRepository = dishRepository;
        this.orderRequestRepository = orderRequestRepository;
        this.orderRequestMapper = orderRequestMapper;
        this.orderResponseRepository = orderResponseRepository;
        this.orderResponseMapper = new OrderResponseMapperImpl();
    }


    @Override
    public List<OrderResponseDTO> getAllOrders() {
        List<OrderResponseEntity> entities = orderResponseRepository.findAll();
        return entities.stream()
                .map(orderResponseMapper::toOrderResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO getOrderById(Long orderId) {
        OrderResponseEntity entity = orderResponseRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found"));
        return orderResponseMapper.toOrderResponseDTO(entity);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        if (!orderResponseRepository.existsById(orderId)) {
            throw new OrderNotFoundException("Order with id " + orderId + " not found");
        }

        orderResponseRepository.deleteById(orderId);
    }

    @Override
    @Transactional
    public OrderResponseDTO processOrder(OrderRequestDTO orderRequestDTO) {
        validateOrderRequest(orderRequestDTO);

        List<Long> dishIds = orderRequestDTO.getDishes()
                .stream()
                .map(DishDTO::getId)
                .collect(Collectors.toList());

        if (dishIds.isEmpty()) {
            throw new EmptyDishListException();
        }

        List<DishEntity> dishes = dishRepository.findAllById(dishIds);
        if (dishes.size() != dishIds.size()) {
            throw new DishIdNotFoundException();
        }

        BigDecimal total = calculateTotal(orderRequestDTO, dishes);

        OrderRequestEntity orderRequestEntity = new OrderRequestEntity();
        orderRequestEntity.setDishes(dishes);
        orderRequestEntity.setDeliveryType(orderRequestDTO.getDeliveryType());

        if (orderRequestDTO.getDeliveryType() == DeliveryType.IN_HOUSE) {
            orderRequestEntity.setWithReservation(orderRequestDTO.isWithReservation());
            orderRequestEntity.setParticipants(orderRequestDTO.getParticipants());
        }

        orderRequestEntity = orderRequestRepository.save(orderRequestEntity);

        OrderResponseEntity orderResponseEntity = new OrderResponseEntity();
        orderResponseEntity.setOrderRequest(orderRequestEntity);
        orderResponseEntity.setDishes(dishes);
        orderResponseEntity.setTotal(total);
        orderResponseEntity.setCreatedAt(LocalDateTime.now());
        orderResponseEntity.setDeliveryType(orderRequestDTO.getDeliveryType());

        if (orderRequestDTO.getDeliveryType() == DeliveryType.IN_HOUSE) {
            orderResponseEntity.setWithReservation(orderRequestDTO.isWithReservation());
            orderResponseEntity.setParticipants(orderRequestDTO.getParticipants());
        }

        orderResponseEntity = orderResponseRepository.save(orderResponseEntity);

        OrderResponseDTO prova = orderResponseMapper.toOrderResponseDTO(
                orderResponseRepository.findById(orderResponseEntity.getOrderId()).get()
        );

        return prova;
    }


    private void validateOrderRequest(OrderRequestDTO orderRequestDTO) {
        if (orderRequestDTO.getDishes() == null || orderRequestDTO.getDishes().isEmpty()) {
            throw new EmptyDishListException();
        }
        if (orderRequestDTO.getDishes().size() > 10) {
            throw new TooManyDishesException();
        }
        if (orderRequestDTO.getDeliveryType() == DeliveryType.IN_HOUSE
                && (orderRequestDTO.getParticipants() == null || orderRequestDTO.getParticipants() <= 0)) {
            throw new InvalidParticipansException();
        }
    }

    private BigDecimal calculateTotal(OrderRequestDTO orderRequestDTO, List<DishEntity> dishes) {
        BigDecimal total = dishes.stream()
                .map(DishEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        switch (orderRequestDTO.getDeliveryType()) {
            case ONLINE: {
                total = total.subtract(new BigDecimal("5.00"));
                if (orderRequestDTO.isWithReservation()) {
                    total = total.subtract(new BigDecimal("2.00"));
                }
                break;
            }

            case TAKE_AWAY: {
                total = total.multiply(new BigDecimal("1.22"));
                break;
            }

            case IN_HOUSE: {
                int partecipans = orderRequestDTO.getParticipants() != null ? orderRequestDTO.getParticipants() : 0;
                total = total.add(new BigDecimal(partecipans * 2));
                break;
            }

            default: {
                throw new InvalidDeliveryTypeException();
            }
        }

        if (total.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidOrderCostException();
        }

        return total;
    }
}
