package com.blackbox.starter.util.blockchain;

import com.blackbox.starter.events.CarEvent;
import com.blackbox.starter.events.CarStartEvent;
import com.blackbox.starter.models.EventBlock;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kida on 29.03.2017.
 */
class MinerTest extends Miner {

    @Test
    static void testAddEvent() throws IOException, InterruptedException {
        //EncryptionUtil.generateKey();
        Miner miner = new Miner();
        miner.start();
        for (int i = 0; i < 4; i++) {
            CarStartEvent event = new CarStartEvent();
            event.setEventId(UUID.randomUUID().toString());
            event.setTimestamp(new Date().getTime());
            event.setTripId("1234567890-"+i);
            event.setEventId(UUID.randomUUID().toString());
            //miner.pendingList.add(event);
            miner.addEvent(event);
        }
        Thread.sleep(120000);
        //miner.join();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, GeneralSecurityException {
        testAddEvent();
        testReadBlockList();

    }

    private static void testReadBlockList() throws IOException, ClassNotFoundException, InterruptedException, GeneralSecurityException {

        ChainDetecter chainDetecter = new ChainDetecter();
        List<EventBlock> blockList =  chainDetecter.getListFromFile(0,99);
        System.out.println(chainDetecter.isChainCorrect(blockList));
        Assert.assertTrue(chainDetecter.isChainCorrect(blockList));
        List<CarEvent> eventList = chainDetecter.getEventList(blockList);
        for (CarEvent event : eventList) {
            System.out.println(event.toString());
        }
     }
}
