package com.scavable.gui.actions;

import com.scavable.gui.LauncherFrame;
import com.scavable.setup.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonActionEvents {
    public static ActionListener aboutAction(){
        return e -> {
            JFrame frame = new JFrame("About");
            frame.getContentPane().setLayout(new GridLayout(2,1));
            frame.getContentPane().add(new JLabel("Application Name: " + Configuration.getAppName()));
            frame.getContentPane().add(new JLabel("Application Version: " + Configuration.getVersion()));
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
                Configuration.setGameDetectionType(choice.getSelectedItem().toString());;
                frame.dispose();
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
        return e -> LauncherFrame.getInstance().dispose();
    }
}
