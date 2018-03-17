/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.command;

import com.skipthedishes.hackathon.orderservice.application.dto.OrderDTO;

/**
 *
 * @author lucas
 */
public class CreateOrderCommand {

    private OrderDTO orderInfo;

    public CreateOrderCommand(OrderDTO orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderDTO getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderDTO orderInfo) {
        this.orderInfo = orderInfo;
    }

}
