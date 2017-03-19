package com.blackbox.starter.controllers;

import com.blackbox.starter.CryptoUtil;
import com.blackbox.starter.EventListener;
import com.blackbox.starter.ethereum.EthereumBean;
import com.blackbox.starter.events.CarEvent;
import com.blackbox.starter.events.CarStartEvent;
import com.blackbox.starter.events.ICarEvent;
import com.blackbox.starter.models.EventBlock;
import com.blackbox.starter.models.EventMessage;
import com.blackbox.starter.models.EventType;
import com.blackbox.starter.util.InterfaceAdapter;
import com.blackbox.starter.util.Miner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaServerTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

/**
 * Created by toktar.
 */
@Component
public class EventController {
    private String tripId = null;
    private String lastEventHash = null;
    private String publicKey;
    private Miner miner;



    @Autowired
    public EventListener start() {
        miner = new Miner();
        miner.start();
        CryptoUtil.generateKey();
        publicKey = CryptoUtil.PUBLIC_KEY_FILE;
        return new EventListener();
    }



    public void setEvent(File eventInFile) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {


        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ICarEvent.class, new InterfaceAdapter());
        Gson gson = builder.create();

        EventMessage eventMessage = gson.fromJson(new FileReader(eventInFile), EventMessage.class);
/*
        switch (eventMessage.getEventType()) {
            case start: saveStart(eventMessage); break;
            case stop: saveStop(eventMessage); break;
            case accident: saveAccident(eventMessage); break;
            case breaking: saveBreaking(eventMessage); break;
            case repair: saveRepair(eventMessage); break;
        }*/
        /*switch (eventMessage.getEventType()) {
            case start:
                eventMessage.setCarEvent(gson.fromJson(eventMessage.getEventInStr(), CarStartEvent.class));
                break;
            case stop:
                eventMessage.setCarEvent(gson.fromJson(eventMessage.getEventInStr(), CarStopEvent.class));
                break;
            case accident:
                eventMessage.setCarEvent(gson.fromJson(eventMessage.getEventInStr(), CarAccidentEvent.class));
                break;
            case breaking:
                eventMessage.setCarEvent(gson.fromJson(eventMessage.getEventInStr(), CarBreakingEvent.class));
                break;
            case repair:
                eventMessage.setCarEvent(gson.fromJson(eventMessage.getEventInStr(), CarRepairEvent.class));
                break;
        }*/


      /*  Block block1 = new Block("start".getBytes());
        Block block2 = new Block(block1.getHash(), );*/

        if (eventMessage != null) {
            CarEvent carEvent = messageConverter(eventMessage);
            miner.addEvent(carEvent);
            /*
            eventMessage.setLastHash(lastEventHash);
            String jsonEvent = gson.toJson(eventMessage);
            jsonEvent = CryptoUtil.encrypt(jsonEvent, CryptoUtil.restorePublic()).toString();
            lastEventHash = jsonEvent;


            try (FileWriter writer = new FileWriter("black_box_history.log", false)) {
                writer.write(jsonEvent);
                writer.append('\n');
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
*/
        }
    }


    private CarEvent messageConverter(EventMessage eventMessage) {
        return null;
    }

    private void saveRepair(EventMessage newEvent) {


    }

    private void saveBreaking(EventMessage newEvent) {

    }

    private void saveAccident(EventMessage newEvent) {

    }

    private void saveStop(EventMessage newEvent) {
        if (tripId == null) newEvent = null;
    }

    private void saveStart(EventMessage newEvent) {
        CarStartEvent carEvent = (CarStartEvent) newEvent.getCarEvent();
        tripId = carEvent.getTripId();
        // Block.Builder blockBuilder = new Block.Builder();
        // {"id":100,"name":"name"}
        //Entity read = gson.fromJson(json, Entity.class);


        //  blockBuilder.
        // currBlock.set
    }
}
