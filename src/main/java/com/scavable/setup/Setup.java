package com.scavable.setup;

import com.scavable.util.Configuration;

import java.io.IOException;
import java.util.Properties;

public class Setup {
    public Setup() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));

        Configuration.setAppName(properties.getProperty("name"));
        Configuration.setVersion(properties.getProperty("version"));
        Configuration.setDeveloper(properties.getProperty("developer"));
        Configuration.setGithub(properties.getProperty("github"));

        ConfigFile.read();
        GamesFile.read();

    }
}
