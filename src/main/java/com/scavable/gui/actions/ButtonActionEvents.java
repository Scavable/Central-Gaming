package com.scavable.gui.actions;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.scavable.util.Configuration;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ButtonActionEvents {
    public static ActionListener aboutAction(){
        return e -> {
            JFrame frame = new JFrame("About");
            JPanel panel = new JPanel();

            Border padding = BorderFactory.createEmptyBorder(5,5,5,5);

            panel.setBorder(padding);
            panel.setLayout(new GridLayout(2,2,5,5));

            panel.add(new JLabel("Application Name: "));
            panel.add(new JLabel(Configuration.getAppName()));
            panel.add(new JLabel("Application Version: "));
            panel.add(new JLabel(Configuration.getVersion()));

            frame.getContentPane().add(panel);

            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        };
    }
    public static ActionListener gameDetectionAction(){
        return e -> {
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new GridLayout(2, 1));

            String[] choices = {"Shortcut Folder", "Root Game Directory"};
            JComboBox<String> choice = new JComboBox<>(choices);

            JButton okayButton = new JButton("Okay");
            okayButton.addActionListener(e1 -> {
                System.out.println(choice.getSelectedItem().toString());
                Configuration.setGameDetectionType(choice.getSelectedItem().toString());
                frame.dispose();

                if(choice.getSelectedItem().toString().contains("Shortcut")){
                    JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    jFileChooser.setDialogTitle("Shortcut's Folder");
                    int result = jFileChooser.showDialog(null, "Select");
                    if(result == JFileChooser.APPROVE_OPTION){
                        File file = jFileChooser.getSelectedFile();
                        Configuration.setShortcutFolder(file);
                        LinkedList<File> games = new LinkedList<>();
                        for (File game : file.listFiles()) {
                            games.add(game);
                        }
                        Configuration.setGames(games);
                    }
                }else{

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
    public static ActionListener exitButtonAction(){
        return e -> {
            System.out.println(Configuration.getConfigMap());
            JsonObject object = new JsonObject(Configuration.getConfigMap());
            try {
                PrintWriter printWriter = new PrintWriter("config.json");
                printWriter.write(object.toJson());
                printWriter.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(Configuration.getGamesMap());
            object = new JsonObject(Configuration.getGamesMap());
            try {
                PrintWriter printWriter = new PrintWriter("games.json");
                printWriter.write(object.toJson());
                printWriter.close();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            System.exit(0);
        };
    }

}
