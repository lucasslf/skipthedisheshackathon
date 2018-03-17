/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.projection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skipthedishes.hackathon.orderservice.application.dto.OrderDTO;
import com.skipthedishes.hackathon.orderservice.application.dto.OrderStatusDTO;
import com.skipthedishes.hackathon.orderservice.domain.model.PlacedOrder;
import com.skipthedishes.hackathon.orderservice.domain.model.OrderRepository;
import com.skipthedishes.hackathon.orderservice.domain.model.vo.OrderStatus;
import com.skipthedishes.hackathon.orderservice.event.Event;
import com.skipthedishes.hackathon.orderservice.event.EventSubscriber;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author lucas
 */
public class OrdersStatusProjection implements EventSubscriber {

    @Autowired
    OrderRepository orderRepository;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void on(Event event) {
        switch (event.getType()) {
            case "CreatedOrder":

                try {
                    OrderDTO orderInfo = mapper.readValue(event.getData(), OrderDTO.class);
                    PlacedOrder order = new PlacedOrder();
                    order.setId(event.getId());
                    order.setStatus(OrderStatus.ORDERED);
                    order.setUsername(orderInfo.getUser());
                    orderRepository.save(order);
                } catch (IOException ex) {
                    throw new RuntimeException("Couldn't consume event", ex);
                }
                break;
            case "CancelledOrder":
                String orderId = event.getData();
                PlacedOrder order = orderRepository.findOne(UUID.fromString(orderId));
                order.setStatus(OrderStatus.CANCELED);
                orderRepository.save(order);
                break;

        }
    }

    public OrderStatusDTO getOrderStatus(UUID id) {
        PlacedOrder order = orderRepository.findOne(id);
        if (order != null) {
            return new OrderStatusDTO(order.getId(), order.getStatus().toString());
        } else {
            return null;
        }
    }

}
