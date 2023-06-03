package com.scavable.setup;

import com.scavable.util.ConfigFile;
import com.scavable.util.Configuration;
import com.scavable.util.GamesFile;

import java.io.IOException;
import java.util.Properties;

public class Setup {
    public Setup() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("app.properties"));

        Configuration.setAppName(properties.getProperty("name"));
        Configuration.setVersion(properties.getProperty("version"));

        ConfigFile.read();
        GamesFile.read();

    }
}
