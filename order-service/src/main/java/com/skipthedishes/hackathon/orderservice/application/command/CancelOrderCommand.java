/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.application.command;

import java.util.UUID;

/**
 *
 * @author lucas
 */
public class CancelOrderCommand {
  
    private UUID orderId;

    public CancelOrderCommand() {
    }

    public CancelOrderCommand(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }
    
    
}
