package com.scavable.gui;

import com.scavable.gui.actions.ButtonActionEvents;
import com.scavable.objects.GameTile;
import com.scavable.util.Configuration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Logger;

public class LauncherFrame extends JFrame {
    Logger logger = Logger.getLogger(this.getClass().getName());

    private static LauncherFrame singleInstance = null;

    protected JButton exitButton = new JButton("X");

    protected JScrollPane scrollPane;

    protected JPanel topPanel = new JPanel();
    protected JPanel gameTileContainer = new JPanel();
    private static JPanel gameTileInfoContainer = new JPanel();
    protected JPanel buttonsBarPanel = new JPanel();

    protected JMenuBar optionsBar = new JMenuBar();
    protected JMenuItem exitMenuItem = new JMenuItem("Exit");
    protected JMenuItem sortAsc = new JMenuItem("Ascending");
    protected JMenuItem sortDesc = new JMenuItem("Descending");
    protected JMenuItem sortRecent = new JMenuItem("Recent");
    protected JMenuItem sortOldest = new JMenuItem("Oldest");
    protected JMenuItem aboutMenuItem = new JMenuItem("About");
    protected JMenuItem gameDetectionMenuItem = new JMenuItem("Game Detection");


    private LauncherFrame() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) (screenSize.getWidth() / 2), (int) (screenSize.getHeight() / 2)));
        setLocation((int) (screenSize.getWidth() / 4), (int) (screenSize.getHeight() / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        actionListeners();
        optionsBar();
        topPanel();
        gameTilePanel();
        buttonsBarPanel();
        gameTileInfoContainer();

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonsBarPanel, BorderLayout.SOUTH);
        getContentPane().add(gameTileInfoContainer, BorderLayout.EAST);

        pack();
        setVisible(true);

    }

    private void gameTileInfoContainer() {
        gameTileInfoContainer.setName("InfoContainer");

        gameTileInfoContainer.setMaximumSize(new Dimension(50, getPreferredSize().height));
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
    }

    public static synchronized LauncherFrame getInstance() {
        if (singleInstance == null)
            singleInstance = new LauncherFrame();

        return singleInstance;
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

    private void gameTilePanel() {

        gameTileContainer.setLayout(new GridLayout(0, 5, 5, 5));
        for (GameTile gameTile : Configuration.getGames()) {
            gameTile.setPreferredSize(new Dimension(getFrameWidth() / 6, getFrameHeight() / 3));
            gameTileContainer.add(gameTile);
        }

        scrollPane = new JScrollPane(gameTileContainer);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
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

    public JPanel getGameTileContainer() {
        return gameTileContainer;
    }

    public void setGameTileContainer(JPanel gameTileContainer) {
        this.gameTileContainer = gameTileContainer;
    }

    public static JPanel getGameTileInfoContainer() {
        return gameTileInfoContainer;
    }

    public void setGameTileInfoContainer(JPanel gameTileInfoContainer) {
        this.gameTileInfoContainer = gameTileInfoContainer;
    }

    public int getFrameWidth() {
        return this.getPreferredSize().width;
    }

    public int getFrameHeight() {
        return this.getPreferredSize().height;
    }
}
