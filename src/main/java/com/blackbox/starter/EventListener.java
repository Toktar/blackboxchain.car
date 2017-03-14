package com.blackbox.starter;

import com.blackbox.starter.ethereum.EthereumBean;
import com.blackbox.starter.events.CarStartEvent;
import com.blackbox.starter.models.EventMessage;
import com.google.gson.Gson;
import org.ethereum.core.Block;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


/**
 * Created by toktar.
 */
public class EventListener {

    private String tripId = null;
    private String lastEventHash = null;
    private String publicKey;

    @Autowired
    EthereumBean ethereumBean;

    @Autowired
    public EventListener start() {
        CryptoUtil.generateKey();
        publicKey = CryptoUtil.PUBLIC_KEY_FILE;
        return new EventListener();
    }

    void setEvent(EventMessage eventMessage) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {

        switch (eventMessage.getEventType()) {
            case start: saveStart(eventMessage); break;
            case stop: saveStop(eventMessage); break;
            case accident: saveAccident(eventMessage); break;
            case breaking: saveBreaking(eventMessage); break;
            case repair: saveRepair(eventMessage); break;
        }

        Block block1 = new Block("start".getBytes());
        Block block2 = new Block(block1.getHash(), );

        if(eventMessage!=null) {
            eventMessage.setLastHash(lastEventHash);
            Gson gson = new Gson();
            String jsonEvent = gson.toJson(eventMessage);
            jsonEvent = CryptoUtil.encrypt(jsonEvent, CryptoUtil.restorePublic()).toString();
            lastEventHash = jsonEvent;


            try(FileWriter writer = new FileWriter("black_box_history.log", false))
            {
                writer.write(jsonEvent);
                writer.append('\n');
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

        }
    }



    private void saveRepair(EventMessage newEvent) {


    }

    private void saveBreaking(EventMessage newEvent) {

    }

    private void saveAccident(EventMessage newEvent) {

    }

    private void saveStop(EventMessage newEvent) {
        if(tripId==null) newEvent = null;
    }

    private void saveStart(EventMessage newEvent) {
        CarStartEvent carEvent = (CarStartEvent)newEvent.getCarEvent();
        tripId = carEvent.getTripId();
        Block.Builder blockBuilder = new Block.Builder();
        // {"id":100,"name":"name"}
        //Entity read = gson.fromJson(json, Entity.class);


      //  blockBuilder.
       // currBlock.set
    }
}
