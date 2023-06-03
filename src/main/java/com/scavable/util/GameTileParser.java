package com.scavable.util;

import com.scavable.objects.GameTile;

import java.io.File;
import java.util.LinkedList;

public class GameTileParser {
    public static LinkedList<GameTile> toGameTiles() {
        LinkedList<GameTile> gamesLinkedList = new LinkedList<>();
        if (Configuration.getGameDetectionType().contains("Shortcut")) {
            File[] games = Configuration.getShortcutFolder().listFiles();
            for (File game : games) {
                gamesLinkedList.add(new GameTile(game.getName()));
            }
            return gamesLinkedList;
        }

        return gamesLinkedList;
    }

    public GameTile toGameTile(String url) {
        GameTile gameTile = new GameTile();
        return gameTile;
    }

    public GameTile toGameTile(File file) {
        GameTile gameTile = new GameTile();
        return gameTile;
    }
}
