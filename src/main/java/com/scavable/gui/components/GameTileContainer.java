package com.scavable.gui.components;

import com.scavable.objects.GameTile;
import com.scavable.util.Configuration;

import javax.swing.*;
import java.awt.*;

public class GameTileContainer {
    static JPanel gameTileContainer = new JPanel();
    static JScrollPane scrollPane;
    public JScrollPane GameTileContainer(Dimension preferredSize) {

        gameTileContainer.setLayout(new GridLayout(0, 5, 5, 5));

        if(Configuration.getGames() != null){
            for (GameTile gameTile : Configuration.getGames()) {
                gameTile.setPreferredSize(new Dimension(preferredSize.width / 6, preferredSize.height / 3));
                gameTileContainer.add(gameTile);
            }


        }

        scrollPane = new JScrollPane(gameTileContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return scrollPane;
    }

    public static JPanel getGameTileContainer() {
        return gameTileContainer;
    }

    public static void setGameTileContainer(JPanel gameTileContainer) {
        GameTileContainer.gameTileContainer = gameTileContainer;
    }

    public static JScrollPane getGameTileScrollPane(){
        return scrollPane;
    }
}
