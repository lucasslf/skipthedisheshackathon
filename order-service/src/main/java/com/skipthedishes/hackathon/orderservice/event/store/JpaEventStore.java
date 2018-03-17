package com.skipthedishes.hackathon.orderservice.event.store;

import com.skipthedishes.hackathon.orderservice.event.Event;
import com.skipthedishes.hackathon.orderservice.event.EventStore;
import com.skipthedishes.hackathon.orderservice.event.EventSubscriber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author lucas
 */
public class JpaEventStore implements EventStore {


    @Autowired
    JpaEventRepository repository;
   
    List<EventSubscriber> subscribers = new ArrayList<>();

    public JpaEventStore(EventSubscriber...subscribers) {
        Collections.addAll(this.subscribers, subscribers);
    }

    
    
    @Override
    public synchronized void store(Event event) {
        repository.save(event);
        subscribers.stream().forEach(s -> s.on(event));
    }
}
