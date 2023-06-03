package com.scavable.objects;

import javax.swing.*;
import java.awt.*;

public class GameTile extends JButton {
    private final String name;
    private final double playTime;
    private final int timesLaunched;
    private final Image gameImage;

    public GameTile() {
        this.name = null;
        this.playTime = 0;
        this.timesLaunched = 0;
        this.gameImage = null;
        this.setText("");
        GameTile.this.addActionListener(e -> System.out.println(GameTile.this));
    }

    public GameTile(String name) {
        this.name = name;
        this.playTime = 0;
        this.timesLaunched = 0;
        this.gameImage = null;
        this.setText(name);
        GameTile.this.addActionListener(e -> System.out.println(GameTile.this));
    }

    public GameTile(String name, double playTime) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = 0;
        this.gameImage = null;
        this.setText(name);
        GameTile.this.addActionListener(e -> System.out.println(GameTile.this));
    }

    public GameTile(String name, double playTime, int timesLaunched) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;
        this.gameImage = null;
        this.setText(name);
        GameTile.this.addActionListener(e -> System.out.println(GameTile.this));
    }

    public GameTile(String name, double playTime, int timesLaunched, Image gameImage) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;
        this.gameImage = gameImage;
        this.setText(name);
        GameTile.this.addActionListener(e -> System.out.println(GameTile.this));
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
