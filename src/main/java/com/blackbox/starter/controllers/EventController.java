package com.blackbox.starter.controllers;

import com.blackbox.starter.events.CarEvent;
import com.blackbox.starter.events.CarStartEvent;
import com.blackbox.starter.events.ICarEvent;
import com.blackbox.starter.models.EventMessage;
import com.blackbox.starter.util.InterfaceAdapter;
import com.blackbox.starter.util.blockchain.Miner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by toktar.
 */

public class EventController {
    private String tripId = null;
    private String lastEventHash = null;
    private String publicKey;
    private Miner miner;




    public EventController() {
        System.out.println("Event controller starting");
        miner = new Miner();
        miner.start();
        System.out.println("Event controller started");

    }



    public void setEvent(File eventInFile) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {


        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(EventMessage.class, new InterfaceAdapter());
        Gson gson = builder.create();

       // EventMessage eventMessage = gson.fromJson(new FileReader(eventInFile), EventMessage.class);
        EventMessage eventMessage = new Gson().fromJson(new FileReader(eventInFile), EventMessage.class);



        if (eventMessage != null) {
            CarEvent carEvent = messageConverter(eventMessage);
            miner.addEvent(carEvent);

        }
    }


    private CarEvent messageConverter(EventMessage eventMessage) {
        CarEvent result = null;
        result = (eventMessage.getStart()!=null)?eventMessage.getStart():result;
        result = (eventMessage.getStop()!=null)?eventMessage.getStop():result;
        result = (eventMessage.getAccident()!=null)?eventMessage.getAccident():result;
        result = (eventMessage.getBreaking()!=null)?eventMessage.getBreaking():result;
        result = (eventMessage.getRepair()!=null)?eventMessage.getRepair():result;
        return result;
    }

    public static void main(String[] args) {
        EventMessage eventMessage = new EventMessage();
        CarStartEvent start = new CarStartEvent();
        start.setTripId("111111");
        start.setTimestamp(22445678);
        start.setDriverId("eeeeeee");
        eventMessage.setStart(start);

    }

}
