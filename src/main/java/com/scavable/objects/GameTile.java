package com.scavable.objects;

import java.awt.*;
import java.io.Serializable;

public class GameTile implements Serializable {
    private final String name;
    private final double playTime;
    private final int timesLaunched;
    private final Image gameImage;

    public GameTile(){
        this.name = null;
        this.playTime = 0;
        this.timesLaunched = 0;
        this.gameImage = null;

    }
    public GameTile(String name, double playTime, int timesLaunched, Image gameImage){
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;
        this.gameImage = gameImage;
    }

    @Override
    public String toString() {
        return "GameTile{" +
                "name='" + name + '\'' +
                ", playTime=" + playTime +
                ", timesLaunched=" + timesLaunched +
                ", gameImage=" + gameImage +
                '}';
    }
}
