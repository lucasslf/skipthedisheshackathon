package com.skipthedishes.hackathon.orderservice.event;

import java.util.UUID;

/**
 *
 * @author lucas
 */
public interface EventStore {
    void store( Event newEvent);
}
