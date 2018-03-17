/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.dto;

import java.util.UUID;

/**
 *
 * @author lucas
 */
public class OrderStatusDTO {
    private UUID orderId;
    private String orderStatus;

    public OrderStatusDTO(UUID orderId, String orderStatus) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
    
    

    
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
}
