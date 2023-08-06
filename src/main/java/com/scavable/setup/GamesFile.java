package com.scavable.setup;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.scavable.objects.GameTile;
import com.scavable.util.Configuration;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Logger;

public class GamesFile {

    public static void read() throws IOException {
        Logger logger = Logger.getLogger(GamesFile.class.getName());

        if (new File("games.json").exists()) {
            logger.info("Games file already exist");

            try (Reader reader = Files.newBufferedReader(Paths.get("games.json"))) {
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if (!parser.isEmpty()) {

                        LinkedList<GameTile> games = new LinkedList<>();
                        JsonArray array = (JsonArray) parser.get("games");

                        for (Object temp : array) {

                            JsonObject object = (JsonObject) temp;

                            games.add(new GameTile(object.get("name").toString().split("\\.")[0],
                                    object.getDouble(Jsoner.mintJsonKey("playTime", null)),
                                    object.getInteger(Jsoner.mintJsonKey("timesLaunched", null)),
                                    (Image) object.get("gameImage"),
                                    (String) object.get("location"),
                                    object.getLong(Jsoner.mintJsonKey("lastLaunched", null))));

                        }

                        Configuration.setGames(games);

                    }
                    else if (Configuration.getGameDetectionType().contains("rootDirectories") &&
                            Configuration.getDirectories() != null) {

                        LinkedList<GameTile> games = new LinkedList<>();
                        File[] files = Configuration.getShortcutFolder().listFiles();

                        if (files != null) {
                            for (File game : files) {
                                games.add(new GameTile(game.getName().split("\\.")[0],
                                        0.0, 0, null, game.getAbsolutePath()));
                            }

                            Configuration.setGames(games);

                        }
                    }
                } catch (JsonException e) {

                //File doesn't have the minimum {}
                //Override file to contain only {}
                if (new File("games.json").createNewFile())
                    logger.info("Unable to clean corrupted games file");

                try(FileWriter fileWriter = new FileWriter("games.json")){
                    fileWriter.write(new JsonObject().toJson());
                }

            }
        }
    }

    public static void write() {
        if (Configuration.getGames() != null) {

            JsonObject object = new JsonObject();
            JsonArray array = new JsonArray();

            for (GameTile game : Configuration.getGames()) {
                array.add(game.toJsonObject());
            }

            object.put("games", array);

            try (PrintWriter printWriter = new PrintWriter("games.json")) {
                printWriter.write(object.toJson());

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}

