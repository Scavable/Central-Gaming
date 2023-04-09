package com.scavable.setup;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Setup {
    public Setup() throws IOException {
        System.out.println("Setup method called");

        Logger logger = Logger.getLogger(this.getClass().getName());

        //Read games file
        File games = new File("games.json");
        if (games.exists()) {
            logger.info("Games file already exist");
        } else {
            boolean status = games.createNewFile();
            if (status) {
                logger.info("Games file was created");
            }
        }

        //Read config file
        File config = new File("config.json");
        System.out.println(config.getAbsolutePath());
        if (config.exists()) {
            logger.info("Config file already exist");
        } else {
            boolean status = config.createNewFile();
            if (status) {
                logger.info("Config file was created");
            }
        }
        System.out.println(config.getName());
    }
}
