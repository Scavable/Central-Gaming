package com.scavable.gui.components;

import com.scavable.gui.actions.ButtonActionEvents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameTileInfoContainer {
    static JPanel gameTileInfoContainer = new JPanel();

    public JPanel GameTileInfoContainer(Dimension preferredSize){
        gameTileInfoContainer.setName("InfoContainer");

        gameTileInfoContainer.setMaximumSize(new Dimension(50, preferredSize.height));
        gameTileInfoContainer.setLayout(new GridLayout(4, 1));
        gameTileInfoContainer.setBorder(new EmptyBorder(10,10,10,10));

        JLabel name = new JLabel("Name: ");
        name.setName("Name");
        JLabel playTime = new JLabel("Playtime: ");
        playTime.setName("Playtime");
        JLabel launches = new JLabel("Times Launched: ");
        launches.setName("Launches");
        JButton play = new JButton("Play");

        play.addActionListener(ButtonActionEvents.playButtonAction());

        gameTileInfoContainer.add(name);
        gameTileInfoContainer.add(playTime);
        gameTileInfoContainer.add(launches);
        gameTileInfoContainer.add(play);

        return gameTileInfoContainer;
    }

    public static JPanel getGameTileInfoContainer() {
        return gameTileInfoContainer;
    }

}
