package com.blackbox.starter.util.blockchain;

import com.blackbox.starter.events.CarStartEvent;
import com.blackbox.starter.models.EventBlock;
import com.blackbox.starter.util.EncryptionUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * Created by Kida on 29.03.2017.
 */
class MinerTest extends Miner {

    @Test
    static void testAddEvent() throws IOException, InterruptedException {
        //EncryptionUtil.generateKey();
        Miner miner = new Miner();
        miner.start();
        for (int i = 0; i < 2; i++) {
            CarStartEvent event = new CarStartEvent();
            event.setTripId("1234567890-"+i);
            //miner.pendingList.add(event);
            miner.addEvent(event);
            Thread.sleep(120000);
        }
        //miner.join();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, GeneralSecurityException {
        //testAddEvent();
        testReadBlockList();

    }

    private static void testReadBlockList() throws IOException, ClassNotFoundException, InterruptedException, GeneralSecurityException {

        ChainDetecter chainDetecter = new ChainDetecter();
        List<EventBlock> blockList =  chainDetecter.getListFromFile(0,99);
        System.out.println(chainDetecter.isChainCorrect(blockList));
        Assert.assertTrue(chainDetecter.isChainCorrect(blockList));
    }
}
