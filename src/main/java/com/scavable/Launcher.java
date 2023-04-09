package com.scavable;

import com.scavable.setup.Setup;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Launcher {

    public static void main(String[] args) throws IOException {
        //Reads needed data before executing LauncherFrame thread for use
        new Setup();

        Runnable runnable = new Thread(LauncherFrame::getInstance);
        runnable.run();

        //System.out.println(Thread.currentThread());
    }

    //Read load settings/files

}
