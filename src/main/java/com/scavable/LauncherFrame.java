package com.scavable;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class LauncherFrame extends JFrame{
    Logger logger = Logger.getLogger(this.getClass().getName());

    private static LauncherFrame singleInstance = null;
    private JPanel gameTileContainer = new JPanel();
    private JPanel gameTileInfoContainer = new JPanel();
    private JPanel buttonsBarContainer = new JPanel();
    private JMenuBar optionsBar = new JMenuBar();
    private final JMenu sortMenu = new JMenu("Sort");
    private final JMenu customizeMenu = new JMenu("Customize");
    private final JMenuItem sortAsc = new JMenuItem("Ascending");
    private final JMenuItem sortDesc = new JMenuItem("Descending");
    private final JMenuItem sortRecent = new JMenuItem("Recent");
    private final JMenuItem sortOldest = new JMenuItem("Oldest");
    private final JButton exitButton = new JButton("X");
    private final JPanel topPanel = new JPanel();

    private LauncherFrame() {

        setUndecorated(true);
        setActionListeners();
        initOptionsBar();

        topPanel.add(optionsBar, BorderLayout.WEST);
        topPanel.add(exitButton, BorderLayout.EAST);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(gameTileContainer, BorderLayout.CENTER);
        getContentPane().add(buttonsBarContainer, BorderLayout.SOUTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) (screenSize.getWidth() / 2), (int) (screenSize.getHeight() / 2)));
        setLocation((int) (screenSize.getWidth() / 4), (int) (screenSize.getHeight() / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        setVisible(true);
    }

    private void setActionListeners() {
        exitButton.addActionListener(ButtonActionEvents.exitButtonAction());
    }


    private void initOptionsBar() {
        optionsBar.add(sortMenu);
        optionsBar.add(customizeMenu);

        sortMenu.add(sortAsc);
        sortMenu.add(sortDesc);
        sortMenu.add(sortRecent);
        sortMenu.add(sortOldest);

    }

    public static synchronized LauncherFrame getInstance() {
        if (singleInstance == null)
            singleInstance = new LauncherFrame();

        return singleInstance;
    }

    public JPanel getButtonsBarContainer() {
        return buttonsBarContainer;
    }

    public void setButtonsBarContainer(JPanel buttonsBarContainer) {
        this.buttonsBarContainer = buttonsBarContainer;
    }

    public JMenuBar getOptionsBar() {
        return optionsBar;
    }

    public void setOptionsBar(JMenuBar optionsBar) {
        this.optionsBar = optionsBar;
    }

    public JPanel getGameTileContainer() {
        return gameTileContainer;
    }

    public void setGameTileContainer(JPanel gameTileContainer) {
        this.gameTileContainer = gameTileContainer;
    }

    public JPanel getGameTileInfoContainer() {
        return gameTileInfoContainer;
    }

    public void setGameTileInfoContainer(JPanel gameTileInfoContainer) {
        this.gameTileInfoContainer = gameTileInfoContainer;
    }
}
