package com.scavable.gui.actions;

import com.scavable.gui.components.GameTileContainer;
import com.scavable.gui.components.GameTileInfoContainer;
import com.scavable.objects.GameTile;
import com.scavable.setup.ConfigFile;
import com.scavable.setup.GamesFile;
import com.scavable.util.Configuration;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class ButtonActionEvents {
    public static ActionListener aboutAction() {
        return e -> {
            JFrame frame = new JFrame("About");
            JPanel panel = new JPanel();

            Border padding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

            panel.setBorder(padding);
            panel.setLayout(new GridLayout(4, 2, 5, 5));

            panel.add(new JLabel("Application Name: "));
            panel.add(new JLabel(Configuration.getAppName()));
            panel.add(new JLabel("Application Version: "));
            panel.add(new JLabel(Configuration.getVersion()));
            panel.add(new JLabel("Application Developer: "));
            panel.add(new JLabel(Configuration.getDeveloper()));
            panel.add(new JLabel("Developer Github: "));
            panel.add(new JLabel(Configuration.getGithub()));

            frame.getContentPane().add(panel);

            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        };
    }

    public static ActionListener gameDetectionAction() {
        return e -> {
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new GridLayout(2, 1));

            String[] choices = {"Shortcut Folder", "Root Game Directory"};
            JComboBox<String> choice = new JComboBox<>(choices);

            JButton okayButton = new JButton("Okay");
            okayButton.addActionListener(e1 -> {
                System.out.println(Objects.requireNonNull(choice.getSelectedItem()));
                Configuration.setGameDetectionType(choice.getSelectedItem().toString());
                frame.dispose();

                if (choice.getSelectedItem().toString().contains("Shortcut")) {
                    JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    jFileChooser.setDialogTitle("Shortcut's Folder");
                    int result = jFileChooser.showDialog(null, "Select");
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser.getSelectedFile();
                        Configuration.setShortcutFolder(file);
                        LinkedList<GameTile> games = new LinkedList<>();
                        for (File game : Objects.requireNonNull(file.listFiles())) {
                            games.add(new GameTile(game.getName()));
                        }
                        Configuration.setGames(games);
                    }
                } else {

                }

            });

            frame.getContentPane().add(choice);
            frame.getContentPane().add(okayButton);

            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        };
    }

    public static ActionListener exitButtonAction() {
        return e -> {
            ConfigFile.write();
            GamesFile.write();
            System.exit(0);
        };
    }

    public static ActionListener playButtonAction(){
        return e -> {
            try {
                JLabel label = (JLabel) GameTileInfoContainer.getGameTileInfoContainer().getComponent(0);
                String name = label.getText();
                System.out.println(name);

                String gameLocation = "";

                for (Component component: GameTileContainer.getGameTileContainer().getComponents()){
                    if(component instanceof GameTile gameTile){
                        if(gameTile.getName().contains(name)){
                            gameLocation = gameTile.getGameLocation();
                        }

                    }
                }

                System.out.println(gameLocation.substring(0, gameLocation.lastIndexOf("\\")));
                Runtime.getRuntime().exec("cmd /c start \"\" " + "\""+gameLocation+"\"");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        };
    }

    public static ActionListener sortAscendingAction(){
        return e -> {
            JPanel panel = (JPanel) GameTileContainer.getGameTileScrollPane().getViewport().getView();
            panel.removeAll();

            LinkedList<GameTile> games = Configuration.getGames();

            games.sort((o1, o2) -> Collator.getInstance().compare(o1.getName(), o2.getName()));

            for(GameTile temp: games){
                panel.add(temp);
            }

            GameTileContainer.getGameTileScrollPane().setViewportView(panel);

        };
    }

    public static ActionListener sortDescendingAction(){
        return e -> {

            JPanel panel = (JPanel) GameTileContainer.getGameTileScrollPane().getViewport().getView();
            panel.removeAll();

            LinkedList<GameTile> games = Configuration.getGames();

            games.sort((o1, o2) -> Collator.getInstance().compare(o2.getName(), o1.getName()));

            for(GameTile temp: games){
                panel.add(temp);
            }

            GameTileContainer.getGameTileScrollPane().setViewportView(panel);
        };
    }

}
