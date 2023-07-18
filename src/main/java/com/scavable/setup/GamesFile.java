package com.scavable.setup;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.scavable.objects.GameTile;
import com.scavable.util.Configuration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Will need to redo this class to instead hold Game Object data instead of game urls only
 */
public class GamesFile {

    public static void read() throws IOException {
        Logger logger = Logger.getLogger(GamesFile.class.getName());

        if (new File("games.json").exists()) {
            logger.info("Games file already exist");

            try (Reader reader = Files.newBufferedReader(Paths.get("games.json"))) {
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if (!parser.isEmpty() &&
                        Configuration.getGameDetectionType().contains("Shortcut") &&
                        Configuration.getShortcutFolder() != null &&
                        Configuration.getShortcutFolder().listFiles() != null) {

                    LinkedList<GameTile> games = new LinkedList<>();
                    File[] files = Configuration.getShortcutFolder().listFiles();

                    if (files != null) {

                        for (File game : files) {
                            if (game.isFile()) {
                                games.add(new GameTile(game.getName().split("\\.")[0],
                                        0.0, 0, null, game.getAbsolutePath()));
                            }
                        }

                        Configuration.setGames(games);
                    }
                } else if (!parser.isEmpty() &&
                        Configuration.getGameDetectionType().contains("rootDirectories") &&
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

                parser.clear();

            } catch (JsonException e) {
                //File doesn't have the minimum {}
                //Override file to contain only {}
                if (new File("games.json").createNewFile())
                    logger.info("Unable to clean corrupted games file");

                JsonObject jsonObject = new JsonObject();
                FileWriter fileWriter = new FileWriter("games.json");
                fileWriter.write(jsonObject.toJson());

                fileWriter.close();
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

