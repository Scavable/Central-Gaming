package com.scavable.setup;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class Setup {
    public Setup() throws IOException {

        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));

        Configuration.setAppName(properties.getProperty("name"));
        Configuration.setVersion(properties.getProperty("version"));

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
        if(new File("config.json").exists()){
            logger.info("Config file already exist");
            try {
                Reader reader = Files.newBufferedReader(Paths.get("config.json"));
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);
                if(parser.isEmpty()){
                    System.out.println("Parser Empty");
                }else {
                    Configuration.setGameDetectionType( (String) parser.get("gameDetectionType"));
                }
                parser.clear();
                reader.close();
            } catch (JsonException e) {

                throw new RuntimeException(e);
            }
        } else{
            logger.info("Config file does not exist");
        }
    }
}
