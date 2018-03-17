/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.domain.service;

import com.skipthedishes.hackathon.orderservice.application.command.CancelOrderCommand;
import com.skipthedishes.hackathon.orderservice.application.command.CreateOrderCommand;
import com.skipthedishes.hackathon.orderservice.event.Event;

/**
 *
 * @author lucas
 */
public interface OrderService {
    
    public Event handle(CreateOrderCommand command);
    
    public Event handle(CancelOrderCommand command);
            
}
