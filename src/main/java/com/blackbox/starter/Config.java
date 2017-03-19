package com.blackbox.starter;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import org.springframework.stereotype.Component;

@Component
public class Config {
    private String eventFolder = "new_event\\";

    public String getEventFolder() {
        return eventFolder;
    }

    public void setEventFolder(String eventFolder) {
        this.eventFolder = eventFolder;
    }


/*  @Bean
    EthereumBean ethereumBean() throws Exception {
        EthereumBean ethereumBean = new EthereumBean();
        Executors.newSingleThreadExecutor().
                submit(ethereumBean::start);

        return ethereumBean;
    }*/
}
