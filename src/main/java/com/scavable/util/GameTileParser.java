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
                gamesLinkedList.add(new GameTile(game.getName().split("\\.")[0]));
            }
            return gamesLinkedList;
        }

        return gamesLinkedList;
    }

    public GameTile toGameTile(String url) {
        return new GameTile();
    }

    public GameTile toGameTile(File file) {
        return new GameTile();
    }
}
