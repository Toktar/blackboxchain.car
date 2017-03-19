package com.blackbox.starter.models;

import com.blackbox.starter.events.CarEvent;

/**
 * Created by toktar.
 */
public class EventBlock {

    private String parentHash;
    private String listHash;
    private CarEvent event;
    private long timestamp;
    private String signature;
    private long sold=0;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }



    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public String getListHash() {
        return listHash;
    }

    public void setListHash(String listHash) {
        this.listHash = listHash;
    }

    public CarEvent getEvent() {
        return event;
    }

    public void setEvent(CarEvent event) {
        this.event = event;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }
}
