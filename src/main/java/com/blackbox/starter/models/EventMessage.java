package com.blackbox.starter.models;


import com.blackbox.starter.events.CarEvent;
import com.blackbox.starter.events.ICarEvent;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by toktar.
 */


public class EventMessage {
    private EventType eventType;
    private String lastHash;

    @JsonProperty(value = "event")
    private ICarEvent carEvent;
    private Object eventObject;

    public Object getEventObject() {
        return eventObject;
    }

    public void setEventObject(Object eventObject) {
        this.eventObject = eventObject;
    }

    public void setCarEvent(ICarEvent carEvent) {
        this.carEvent = carEvent;
    }

    public String getLastHash() {
        return lastHash;
    }

    public void setLastHash(String lastHash) {
        this.lastHash = lastHash;
    }

    public ICarEvent getCarEvent() {
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

}
