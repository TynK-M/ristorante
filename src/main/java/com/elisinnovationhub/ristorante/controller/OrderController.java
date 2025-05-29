package com.elisinnovationhub.ristorante.controller;

import com.elisinnovationhub.ristorante.model.dto.OrderRequestDTO;
import com.elisinnovationhub.ristorante.model.dto.OrderResponseDTO;
import com.elisinnovationhub.ristorante.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // GET /api/v1/orders
    @Operation(summary = "Ottieni tutti gli ordini")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ordini trovati")
    })
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
    // GET /api/v1/orders/{orderId}
    @Operation(summary = "Ottieni ordine da ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ordine trovato"),
            @ApiResponse(responseCode = "404", description = "Ordine non trovato")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        OrderResponseDTO order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
    // POST /api/v1/orders/create
    @Operation(summary = "Crea un nuovo ordine")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ordine creato con successo"),
            @ApiResponse(responseCode = "400", description = "Input non validi"),
            @ApiResponse(responseCode = "404", description = "Piatti non trovati")
    })
    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO order = orderService.processOrder(orderRequestDTO);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
