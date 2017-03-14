package com.blackbox.starter.models;


import com.blackbox.starter.events.CarEvent;

/**
 * Created by toktar.
 */


public class EventMessage {
    private EventType eventType;
    private String lastHash;

    public String getLastHash() {
        return lastHash;
    }

    public void setLastHash(String lastHash) {
        this.lastHash = lastHash;
    }

    public CarEvent getCarEvent() {
        return carEvent;
    }

    public void setCarEvent(CarEvent carEvent) {
        this.carEvent = carEvent;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    private CarEvent carEvent;
}
