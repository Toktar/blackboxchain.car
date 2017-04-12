package com.blackbox.starter;


public class Config {
    private String eventFolder = "emulator\\new_events\\";

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
