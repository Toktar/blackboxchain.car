package com.blackbox.starter.controllers;

import org.ethereum.core.Block;
import org.ethereum.facade.Ethereum;

/**
 * Created by Kida on 12.03.2017.
 */
public class BlockController {

    public Block generateBlock() {
        Block block = new Block();
        return block;
    }

    public Block generateStartBlock(byte[] data) {
        Block block = new Block(data);
        return block;
    }

    public void chainGenerate(Ethereum ethereum) {
        ethereum.getBlockchain().

    }



}
