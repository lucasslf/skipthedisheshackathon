/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skipthedishes.hackathon.orderservice.event.store;

import com.skipthedishes.hackathon.orderservice.event.Event;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author lucas
 */
public interface JpaEventRepository extends JpaRepository<Event, UUID> {
    
}
