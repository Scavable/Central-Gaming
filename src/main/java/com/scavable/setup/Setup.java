package com.scavable.setup;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.scavable.util.Configuration;

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
        if(new File("games.json").exists()){
            logger.info("Games file already exist");
            try {

                Reader reader = Files.newBufferedReader(Paths.get("games.json"));
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if(!parser.isEmpty()){
                    //Do something
                }

                parser.clear();
                reader.close();
            } catch (JsonException e) {
                boolean result = new File("games.json").createNewFile();

                JsonObject jsonObject = new JsonObject();
                FileWriter fileWriter = new FileWriter("games.json");
                fileWriter.write(jsonObject.toJson());

                fileWriter.close();
            }
        } else{
            logger.info("Config file does not exist");
        }

        //Read config file
        if(new File("config.json").exists()){
            logger.info("Config file already exist");
            try {

                Reader reader = Files.newBufferedReader(Paths.get("config.json"));
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if(!parser.isEmpty())
                    Configuration.setGameDetectionType( (String) parser.get("gameDetectionType"));

                parser.clear();
                reader.close();
            } catch (JsonException e) {
                boolean result = new File("config.json").createNewFile();

                JsonObject jsonObject = new JsonObject();
                FileWriter fileWriter = new FileWriter("config.json");
                fileWriter.write(jsonObject.toJson());

                fileWriter.close();
            }
        } else{
            logger.info("Config file does not exist");
        }
    }
}
