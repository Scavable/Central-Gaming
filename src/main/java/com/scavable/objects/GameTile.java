package com.scavable.objects;

import com.scavable.gui.components.GameTileInfoContainer;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class GameTile extends JButton {
    private String gameLocation = null;
    private final String name;
    private double playTime = 0;
    private int timesLaunched = 0;
    private Image gameImage = null;
    private long lastLaunched = 0;

    public GameTile() {
        this.name = null;
        this.playTime = 0;
        this.timesLaunched = 0;
        this.gameImage = null;
        this.gameLocation = null;

        setOpaque(true);
        setText(name);

        GameTile.this.addActionListener(e -> {
            GameTileInfoContainer.getGameTileInfoContainer().setVisible(!GameTileInfoContainer.getGameTileInfoContainer().isVisible());
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText("Name: " + name);
                        case "Playtime" -> ((JLabel) comp).setText("Playtime: " + playTime);
                        case "Launches" -> ((JLabel) comp).setText("Times Launched: " + timesLaunched);
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });

    }

    public GameTile(String name) {

        this.name = name;

        setText(name);

        GameTile.this.addActionListener(e -> {
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText("Name: " + name);
                        case "Playtime" -> ((JLabel) comp).setText("Playtime: " + playTime);
                        case "Launches" -> ((JLabel) comp).setText("Times Launched: " + timesLaunched);
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });

    }

    public GameTile(String name, double playTime) {
        this.name = name;
        this.playTime = playTime;

        this.setText(name);

        GameTile.this.addActionListener(e -> {
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText(name);
                        case "Playtime" -> ((JLabel) comp).setText(String.valueOf(playTime));
                        case "Launches" -> ((JLabel) comp).setText(String.valueOf(timesLaunched));
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });
    }

    public GameTile(String name, double playTime, int timesLaunched) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;

        this.setText(name);

        GameTile.this.addActionListener(e -> {
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText(name);
                        case "Playtime" -> ((JLabel) comp).setText(String.valueOf(playTime));
                        case "Launches" -> ((JLabel) comp).setText(String.valueOf(timesLaunched));
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });
    }

    public GameTile(String name, double playTime, int timesLaunched, Image gameImage, String gameLocation) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;
        this.gameImage = gameImage;
        this.gameLocation = gameLocation;

        this.setText(name);

        GameTile.this.addActionListener(e -> {
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText(name);
                        case "Playtime" -> ((JLabel) comp).setText(String.valueOf(playTime));
                        case "Launches" -> ((JLabel) comp).setText(String.valueOf(timesLaunched));
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });
    }

    public GameTile(String name, double playTime, int timesLaunched, Image gameImage, String gameLocation, long lastLaunched) {
        this.name = name;
        this.playTime = playTime;
        this.timesLaunched = timesLaunched;
        this.gameImage = gameImage;
        this.gameLocation = gameLocation;
        this.lastLaunched = lastLaunched;

        this.setText(name);

        GameTile.this.addActionListener(e -> {
            for (Component comp : GameTileInfoContainer.getGameTileInfoContainer().getComponents()) {
                if (comp instanceof JLabel) {
                    switch (comp.getName()) {
                        case "Name" -> ((JLabel) comp).setText(name);
                        case "Playtime" -> ((JLabel) comp).setText(String.valueOf(playTime));
                        case "Launches" -> ((JLabel) comp).setText(String.valueOf(timesLaunched));
                        default -> {
                        }
                    }
                }

            }

            System.out.println(GameTile.this);
        });
    }

    @Override
    public String toString() {
        return "GameTile{" +
                "name='" + name + '\'' +
                ", playTime=" + playTime +
                ", timesLaunched=" + timesLaunched +
                ", gameImage=" + gameImage +
                ", location=" + gameLocation +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    public double getPlayTime() {
        return playTime;
    }

    public int getTimesLaunched() {
        return timesLaunched;
    }

    public long getLastLaunched() {
        return lastLaunched;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public Image getGameImage() {
        return gameImage;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setPlayTime(double playTime) {
        this.playTime = playTime;
    }

    public void setTimesLaunched(int timesLaunched) {
        this.timesLaunched = timesLaunched;
    }

    public void setLastLaunched(long lastLaunched) {
        this.lastLaunched = lastLaunched;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public void setGameImage(Image gameImage) {
        this.gameImage = gameImage;
    }
}
