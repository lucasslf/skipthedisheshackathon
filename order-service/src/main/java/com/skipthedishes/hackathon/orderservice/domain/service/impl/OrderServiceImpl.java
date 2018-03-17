/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.domain.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skipthedishes.hackathon.orderservice.application.command.CancelOrderCommand;
import com.skipthedishes.hackathon.orderservice.application.command.CreateOrderCommand;
import com.skipthedishes.hackathon.orderservice.domain.service.OrderService;
import com.skipthedishes.hackathon.orderservice.event.Event;
import com.skipthedishes.hackathon.orderservice.event.EventStore;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lucas
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    EventStore eventStore;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Event handle(CreateOrderCommand command) {

        Event event;
        try {
            event = new Event(UUID.randomUUID(), "CreatedOrder", mapper.writeValueAsString(command.getOrderInfo()));
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Something went wrong!", ex);
        }
        eventStore.store(event);
        return event;

    }

    @Override
    public Event handle(CancelOrderCommand command) {
        Event event = new Event(UUID.randomUUID(), "CancelledOrder", command.getOrderId().toString());
        eventStore.store(event);
        return event;
    }

}
