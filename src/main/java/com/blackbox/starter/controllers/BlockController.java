/*
package com.blackbox.starter.controllers;

import com.blackbox.starter.events.CarEvent;
import com.blackbox.starter.models.EventBlock;
import com.blackbox.starter.util.blockchain.Miner;
import org.ethereum.core.*;
import org.ethereum.core.BlockHeader;
import org.ethereum.core.Transaction;
import org.ethereum.facade.Ethereum;
import org.springframework.stereotype.Component;

import java.util.List;

*/
/**
 * Created by Kida on 12.03.2017.
 *//*

@Component
public class BlockController {

    List<EventBlock> eventList;

    public Block generateBlock2(byte[] parentHash, byte[] unclesHash, byte[] coinbase, byte[] logsBloom,
                                byte[] difficulty, long number, byte[] gasLimit,
                                long gasUsed, long timestamp, byte[] extraData,
                                byte[] mixHash, byte[] nonce, byte[] receiptsRoot,
                                byte[] transactionsRoot, byte[] stateRoot,
                                List<Transaction> transactionsList, List<BlockHeader> uncleList) {


        Block block =null;
        return block;
    }


    public EventBlock generatePendingBlock(CarEvent eventMessage) {
        EventBlock eventBlock = new EventBlock();
        eventBlock.setEvent(eventMessage);
        new Miner(eventBlock, this).start();


        return null;
    }
    public Block generateStartBlock(byte[] data) {
        Block block = new Block(data);
        return block;
    }

    public void chainGenerate(Ethereum ethereum) {
       // ethereum.getBlockchain().

    }


    public void addBlock(CarEvent eventMessage) {
        EventBlock eventBlock = generatePendingBlock(eventMessage);



    }

    public synchronized void setBlockWithNonce(EventBlock eventBlock) {
        eventList.add(eventBlock);
        //TODO: save to file
    }
}
*/
