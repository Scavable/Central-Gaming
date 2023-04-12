package com.scavable;

import com.scavable.gui.LauncherFrame;
import com.scavable.setup.Setup;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException {

        //Reads needed data before executing LauncherFrame thread for use
        new Setup();

        Runnable runnable = new Thread(LauncherFrame::getInstance);
        runnable.run();

        //System.out.println(Thread.currentThread());
    }

}
