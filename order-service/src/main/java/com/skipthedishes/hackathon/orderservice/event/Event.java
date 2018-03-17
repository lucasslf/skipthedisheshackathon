package com.skipthedishes.hackathon.orderservice.event;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lucas
 */
@Entity
public class Event {
    
    @Id
    private UUID id;

    
    //TODO: ENUM
    private String type;
    
    private String data;

    public Event() {
    }

    public Event(UUID id, String type, String data) {
        this.id = id;
        this.type = type;
        this.data = data;
    }
    
    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    
    
}
