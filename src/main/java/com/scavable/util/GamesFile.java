package com.scavable.util;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.scavable.objects.GameTile;

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
            try {

                Reader reader = Files.newBufferedReader(Paths.get("games.json"));
                JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

                if (!parser.isEmpty()) {
                    if (Configuration.getGameDetectionType().contains("Shortcut") && Configuration.getShortcutFolder() != null && Configuration.getShortcutFolder().listFiles() != null) {
                        LinkedList<GameTile> games = new LinkedList<>();
                        File[] files = Configuration.getShortcutFolder().listFiles();
                        if (files != null) {
                            for (File game : files) {
                                games.add(new GameTile(game.getName()));
                            }
                            Configuration.setGames(games);
                        }

                    }
                }

                parser.clear();
                reader.close();
            } catch (JsonException e) {
                //File doesn't have the minimum {}
                //Override file to contain only {}
                boolean result = new File("games.json").createNewFile();
                if (result)
                    logger.info("Unable to clean corrupted games file");

                JsonObject jsonObject = new JsonObject();
                FileWriter fileWriter = new FileWriter("games.json");
                fileWriter.write(jsonObject.toJson());

                fileWriter.close();
            }
        }
    }

    public static void write() {
        System.out.println(Configuration.getGamesMap());
        if (!Configuration.getGamesMap().isEmpty()) {
            JsonObject object = new JsonObject(Configuration.getGamesMap());
            try {
                PrintWriter printWriter = new PrintWriter("games.json");
                printWriter.write(object.toJson());
                printWriter.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
