package com.scavable.setup;

public class Configuration {

    static String version;
    static String appName;
    static String gameDetectionType;

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
}
