package com.blackbox.starter.events;

/**
 * Created by toktar.
 */
public abstract class CarEvent {

    private long timestamp;
    private String eventId;
    private long mileage;

    public long getMileage() {
        return mileage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getEventId() {
        return eventId;
    }

}
