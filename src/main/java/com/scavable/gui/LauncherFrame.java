package com.scavable.gui;

import com.scavable.gui.actions.ButtonActionEvents;
import com.scavable.gui.components.GameTileContainer;
import com.scavable.gui.components.GameTileInfoContainer;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class LauncherFrame extends JFrame {
    Logger logger = Logger.getLogger(this.getClass().getName());

    private static LauncherFrame singleInstance = null;

    protected JButton exitButton = new JButton("X");

    protected JPanel topPanel = new JPanel();

    protected JPanel buttonsBarPanel = new JPanel();

    protected JMenuBar optionsBar = new JMenuBar();
    protected JMenuItem exitMenuItem = new JMenuItem("Exit");
    protected JMenuItem sortAsc = new JMenuItem("Ascending");
    protected JMenuItem sortDesc = new JMenuItem("Descending");
    protected JMenuItem sortRecent = new JMenuItem("Recent");
    protected JMenuItem sortOldest = new JMenuItem("Oldest");
    protected JMenuItem aboutMenuItem = new JMenuItem("About");
    protected JMenuItem gameDetectionMenuItem = new JMenuItem("Game Detection");

    JScrollPane gameTileContainer;
    JPanel gameTileInfoContainer;


    public LauncherFrame() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) (screenSize.getWidth() / 2), (int) (screenSize.getHeight() / 2)));
        setLocation((int) (screenSize.getWidth() / 4), (int) (screenSize.getHeight() / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        actionListeners();
        optionsBar();
        topPanel();
        buttonsBarPanel();

        //Since LauncherFrame is Synchronized, an outside Class cannot reference it
        gameTileContainer = new GameTileContainer().GameTileContainer(this.getPreferredSize());
        gameTileInfoContainer = new GameTileInfoContainer().GameTileInfoContainer(this.getPreferredSize());

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(gameTileContainer, BorderLayout.CENTER);
        getContentPane().add(buttonsBarPanel, BorderLayout.SOUTH);
        getContentPane().add(gameTileInfoContainer, BorderLayout.EAST);

        pack();
        setVisible(true);

    }

    private void topPanel() {

        SpringLayout layout = new SpringLayout();
        topPanel.setLayout(layout);
        topPanel.setPreferredSize(new Dimension(getPreferredSize().width, (int)(exitButton.getPreferredSize().height * 1.4)));

        topPanel.add(optionsBar);
        topPanel.add(exitButton);

        layout.putConstraint(SpringLayout.WEST, optionsBar, 5, SpringLayout.WEST, topPanel);
        layout.putConstraint(SpringLayout.NORTH, optionsBar, 5, SpringLayout.NORTH, topPanel);
        layout.putConstraint(SpringLayout.EAST, exitButton, -5, SpringLayout.EAST, topPanel);
        layout.putConstraint(SpringLayout.NORTH, exitButton, 5, SpringLayout.NORTH, topPanel);
    }



    private void buttonsBarPanel() {

    }

    private void actionListeners() {

        exitMenuItem.addActionListener(ButtonActionEvents.exitButtonAction());
        gameDetectionMenuItem.addActionListener(ButtonActionEvents.gameDetectionAction());
        aboutMenuItem.addActionListener(ButtonActionEvents.aboutAction());
        exitButton.addActionListener(ButtonActionEvents.exitButtonAction());
    }

    private void optionsBar() {

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu sortMenu = new JMenu("Sort");
        JMenu customizeMenu = new JMenu("Customize");

        sortAsc.addActionListener(ButtonActionEvents.sortAscendingAction());
        sortDesc.addActionListener(ButtonActionEvents.sortDescendingAction());


        optionsBar.add(fileMenu);
        optionsBar.add(editMenu);
        optionsBar.add(sortMenu);
        optionsBar.add(customizeMenu);

        fileMenu.add(exitMenuItem);

        editMenu.add(gameDetectionMenuItem);

        sortMenu.add(sortAsc);
        sortMenu.add(sortDesc);
        sortMenu.add(sortRecent);
        sortMenu.add(sortOldest);

        optionsBar.add(aboutMenuItem);
    }

    public JPanel getButtonsBarPanel() {
        return buttonsBarPanel;
    }

    public void setButtonsBarPanel(JPanel buttonsBarPanel) {
        this.buttonsBarPanel = buttonsBarPanel;
    }

    public JMenuBar getOptionsBar() {
        return optionsBar;
    }

    public void setOptionsBar(JMenuBar optionsBar) {
        this.optionsBar = optionsBar;
    }

    public JScrollPane getGameTileContainer() {
        return gameTileContainer;
    }

    public JPanel getGameTileInfoContainer() {
        return gameTileInfoContainer;
    }

    public int getFrameWidth() {
        return this.getPreferredSize().width;
    }

    public int getFrameHeight() {
        return this.getPreferredSize().height;
    }

    public static synchronized LauncherFrame getInstance() {
        if (singleInstance == null)
            singleInstance = new LauncherFrame();

        return singleInstance;
    }
}
