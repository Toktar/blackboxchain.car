package com.blackbox.starter.controllers;

import org.ethereum.core.Block;
import org.ethereum.core.BlockHeader;
import org.ethereum.core.Transaction;
import org.ethereum.facade.Ethereum;

import java.util.List;

/**
 * Created by Kida on 12.03.2017.
 */
public class BlockController {

    public Block generateBlock2(byte[] parentHash, byte[] unclesHash, byte[] coinbase, byte[] logsBloom,
                                byte[] difficulty, long number, byte[] gasLimit,
                                long gasUsed, long timestamp, byte[] extraData,
                                byte[] mixHash, byte[] nonce, byte[] receiptsRoot,
                                byte[] transactionsRoot, byte[] stateRoot,
                                List<Transaction> transactionsList, List<BlockHeader> uncleList) {


        Block block =null;
        return block;
    }


    public Block generateBlock2() {


       // Block block = new Block();
        return null;
    }
    public Block generateStartBlock(byte[] data) {
        Block block = new Block(data);
        return block;
    }

    public void chainGenerate(Ethereum ethereum) {
       // ethereum.getBlockchain().

    }



}
