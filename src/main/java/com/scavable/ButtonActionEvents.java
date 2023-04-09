package com.scavable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionEvents {
    public static ActionListener exitButtonAction(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LauncherFrame.getInstance().dispose();
            }
        };
    }
}
