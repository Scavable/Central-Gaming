package com.scavable.util;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.scavable.objects.GameTile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Configuration {

    private static String version;
    private static String appName;
    private static String developer;
    private static String github;
    private static String gameDetectionType;
    private static File shortcutFolder;
    private static LinkedList<File> rootDirectories;
    private static LinkedList<GameTile> games;

    public static LinkedList<GameTile> getGames() {
        return games;
    }

    public static void setGames(LinkedList<GameTile> games) {
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

    public static String getDeveloper() {
        return developer;
    }

    public static void setDeveloper(String developer) {
        Configuration.developer = developer;
    }

    public static String getGithub() {
        return github;
    }

    public static void setGithub(String github) {
        Configuration.github = github;
    }

    public static String getGameDetectionType() {
        return gameDetectionType;
    }

    public static void setGameDetectionType(String gameDetectionType) {
        Configuration.gameDetectionType = gameDetectionType;
    }

    public static JsonObject getConfigJsonObject() {
        JsonObject object = new JsonObject();
        object.put("appName", appName);
        object.put("gameDetectionType", gameDetectionType);
        object.put("version", version);

        if (gameDetectionType.contains("Shortcut")){
            object.put("shortcutFolder", shortcutFolder.getAbsolutePath());
        }
        else if (gameDetectionType.contains("Root")) {
            object.put("rootDirectories", rootDirectories);
        }

        return object;
    }

}
