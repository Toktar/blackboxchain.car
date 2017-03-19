package com.blackbox.starter.util;

import com.blackbox.starter.models.EventBlock;

/**
 * Created by toktar.
 */
public class SolidGenerator extends Thread {

    public void setEventBlock(EventBlock eventBlock) {
        this.eventBlock = eventBlock;
    }

    private EventBlock eventBlock;

    @Override
    public void run()	//Этот метод будет выполнен в побочном потоке
    {

    }




}
