package com.scavable.util;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Configuration {

    static String version;
    static String appName;
    static String gameDetectionType;
    static File shortcutFolder;
    static LinkedList<File> rootDirectories;
    static LinkedList<File> games;

    public static LinkedList<File> getGames() {
        return games;
    }

    public static void setGames(LinkedList<File> games) {
        Configuration.games = games;
    }

    public static File getShortcutFolder() {
        return shortcutFolder;
    }

    public static void setShortcutFolder(File shortcutFolder) {
        Configuration.shortcutFolder = shortcutFolder;
    }

    public static LinkedList<File> getDirectories() {
        return rootDirectories;
    }

    public static void setDirectories(LinkedList<File> directories) {
        Configuration.rootDirectories = directories;
    }



    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        Configuration.version = version;
    }

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        Configuration.appName = appName;
    }

    public static String getGameDetectionType() {
        return gameDetectionType;
    }

    public static void setGameDetectionType(String gameDetectionType) {
        Configuration.gameDetectionType = gameDetectionType;
    }

    public static Map<String, Object> getConfigMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("appName", appName);
        map.put("gameDetectionType", gameDetectionType);
        map.put("version", version);

        if(gameDetectionType.contains("Shortcut"))
            map.put("shortcutFolder", shortcutFolder.getAbsolutePath());
        else if (gameDetectionType.contains("Root")) {
            map.put("rootDirectories", rootDirectories);
        }

        return map;
    }

    public static Map<String, Object> getGamesMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("games", games.toString());
        return map;
    }
}
