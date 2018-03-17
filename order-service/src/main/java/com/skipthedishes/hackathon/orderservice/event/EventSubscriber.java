/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.event;

import java.util.List;

/**
 *
 * @author lucas
 */
public interface EventSubscriber {

    void on(Event event);

    default void dispatch(List<Event> events) {
        events.forEach(this::on);
    }
}
