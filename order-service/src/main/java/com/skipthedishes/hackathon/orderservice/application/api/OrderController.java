/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.api;

import com.skipthedishes.hackathon.orderservice.application.command.CancelOrderCommand;
import com.skipthedishes.hackathon.orderservice.application.command.CreateOrderCommand;
import com.skipthedishes.hackathon.orderservice.application.dto.OrderDTO;
import com.skipthedishes.hackathon.orderservice.application.dto.OrderStatusDTO;
import com.skipthedishes.hackathon.orderservice.domain.service.OrderService;
import com.skipthedishes.hackathon.orderservice.event.Event;
import com.skipthedishes.hackathon.orderservice.projection.OrdersStatusProjection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrdersStatusProjection ordersStatusProjection;

    @RequestMapping(path = "order", method = RequestMethod.POST, consumes = {"application/json"})
    public UUID createOrder(@RequestBody OrderDTO order) {
        CreateOrderCommand command = new CreateOrderCommand(order);
        Event event = orderService.handle(command);
        return event.getId();

    }

    @RequestMapping(path = "order/{id}/cancellation", method = RequestMethod.PUT)
    public void cancelOrder(@PathVariable("id") String id) {
        CancelOrderCommand command = new CancelOrderCommand(UUID.fromString(id));
        Event event = orderService.handle(command);
    }

    @RequestMapping(path = "order/{id}/status")
    public OrderStatusDTO getOrderStatus(@PathVariable("id") String id) {
        return ordersStatusProjection.getOrderStatus(UUID.fromString(id));

    }
}
