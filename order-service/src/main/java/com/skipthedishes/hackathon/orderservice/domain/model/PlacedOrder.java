/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.domain.model;

import com.skipthedishes.hackathon.orderservice.domain.model.vo.OrderStatus;
import com.skipthedishes.hackathon.orderservice.application.command.CreateOrderCommand;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */
@Entity
public class PlacedOrder {

    @Id
    private UUID id;
    @Column
    private OrderStatus status;
    @Column
    private String username;

    //Product List
    public PlacedOrder() {
    }

    public void process(CreateOrderCommand command) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.ORDERED;
        this.username = command.getOrderInfo().getUser();

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
