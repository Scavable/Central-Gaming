package com.scavable.objects;

import com.scavable.gui.LauncherFrame;

import javax.swing.*;
import java.awt.*;
import java.util.OptionalDouble;

public class GameTile extends JButton {
    private String gameLocation = null;
    private String name = null;
    private double playTime = 0;
    private int timesLaunched = 0;
    private Image gameImage = null;

    public GameTile() {
        this.name = null;
        this.playTime = 0;
        this.timesLaunched = 0;
        this.gameImage = null;
        this.gameLocation = null;

        setOpaque(true);
        setText(name);

        GameTile.this.addActionListener(e -> {
            LauncherFrame.getGameTileInfoContainer().setVisible(!LauncherFrame.getGameTileInfoContainer().isVisible());
            for (Component comp : LauncherFrame.getGameTileInfoContainer().getComponents()) {
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
            for (Component comp : LauncherFrame.getGameTileInfoContainer().getComponents()) {
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
            for (Component comp : LauncherFrame.getGameTileInfoContainer().getComponents()) {
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
            for (Component comp : LauncherFrame.getGameTileInfoContainer().getComponents()) {
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
            for (Component comp : LauncherFrame.getGameTileInfoContainer().getComponents()) {
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

    public String getGameLocation() {
        return gameLocation;
    }
}
