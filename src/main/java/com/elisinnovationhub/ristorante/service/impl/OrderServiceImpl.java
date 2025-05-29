package com.elisinnovationhub.ristorante.service.impl;

import com.elisinnovationhub.ristorante.mapper.OrderResponseMapper;
import com.elisinnovationhub.ristorante.repository.OrderResponseRepository;
import com.elisinnovationhub.ristorante.service.OrderResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderResponseServiceImpl implements OrderResponseService {

    private final OrderResponseRepository orderResponseRepository;
    private final OrderResponseMapper orderResponseMapper;

    @Autowired
    public OrderResponseServiceImpl(OrderResponseRepository orderResponseRepository, OrderResponseMapper orderResponseMapper) {
        this.orderResponseRepository = orderResponseRepository;
        this.orderResponseMapper = orderResponseMapper;
    }


}
