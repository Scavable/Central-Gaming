package com.scavable.util;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Logger;

public class ConfigFile {

    public static void read() throws IOException {
        Logger logger = Logger.getLogger(ConfigFile.class.getName());

        //Read config file
        if (new File("config.json").exists()) {
            logger.info("Config file already exist");

            try (Reader reader = Files.newBufferedReader(Paths.get("config.json"))){
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if (!parser.isEmpty()) {
                    Configuration.setGameDetectionType((String) parser.get("gameDetectionType"));
                    File file = new File((String) parser.get("shortcutFolder"));
                    Configuration.setShortcutFolder(file);
                    Configuration.setDirectories((LinkedList<File>) parser.get("rootDirectories"));
                }

                parser.clear();

            } catch (JsonException e) {
                //File doesn't have the minimum {}
                //Override file to contain only {}
                if (new File("config.json").createNewFile())
                    logger.info("Unable to clean corrupted config file");

                JsonObject jsonObject = new JsonObject();
                FileWriter fileWriter = new FileWriter("config.json");
                fileWriter.write(jsonObject.toJson());

                fileWriter.close();
            }
        } else {
            logger.info("Config file does not exist");
        }
    }

    public static void write() {
        JsonObject object = new JsonObject(Configuration.getConfigMap());
        try (PrintWriter printWriter = new PrintWriter("config.json")){
            printWriter.write(object.toJson());

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
