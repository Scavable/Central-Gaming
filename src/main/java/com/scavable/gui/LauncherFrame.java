package com.scavable.gui;

import com.scavable.gui.actions.ButtonActionEvents;
import com.scavable.objects.GameTile;
import com.scavable.util.GameTileParser;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class LauncherFrame extends JFrame {
    private static LauncherFrame singleInstance = null;
    private final JPanel topPanel = new JPanel();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenuItem exitMenuItem = new JMenuItem("Exit");
    private final JMenu editMenu = new JMenu("Edit");
    private final JMenuItem gameDetectionMenuItem = new JMenuItem("Game Detection");
    private final JMenu sortMenu = new JMenu("Sort");
    private final JMenu customizeMenu = new JMenu("Customize");
    private final JMenuItem sortAsc = new JMenuItem("Ascending");
    private final JMenuItem sortDesc = new JMenuItem("Descending");
    private final JMenuItem sortRecent = new JMenuItem("Recent");
    private final JMenuItem sortOldest = new JMenuItem("Oldest");
    private final JMenuItem aboutMenuItem = new JMenuItem("About");
    private final JButton exitButton = new JButton("X");
    Logger logger = Logger.getLogger(this.getClass().getName());
    JScrollPane scrollPane;
    private JPanel gameTileContainer = new JPanel();
    private JPanel gameTileInfoContainer = new JPanel();
    private JPanel buttonsBarPanel = new JPanel();
    private JMenuBar optionsBar = new JMenuBar();


    private LauncherFrame() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) (screenSize.getWidth() / 2), (int) (screenSize.getHeight() / 2)));
        setLocation((int) (screenSize.getWidth() / 4), (int) (screenSize.getHeight() / 4));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        setActionListeners();
        initOptionsBar();
        initTopPanel();
        initGameTilePanel();
        initButtonsBarPanel();

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonsBarPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    public static synchronized LauncherFrame getInstance() {
        if (singleInstance == null)
            singleInstance = new LauncherFrame();

        return singleInstance;
    }

    private void initTopPanel() {

        SpringLayout layout = new SpringLayout();
        topPanel.setLayout(layout);
        topPanel.setPreferredSize(new Dimension((int) getPreferredSize().getWidth(), (int) (exitButton.getPreferredSize().height * 1.4)));

        topPanel.add(optionsBar);
        topPanel.add(exitButton);

        layout.putConstraint(SpringLayout.WEST, optionsBar, 5, SpringLayout.WEST, topPanel);
        layout.putConstraint(SpringLayout.NORTH, optionsBar, 5, SpringLayout.NORTH, topPanel);
        layout.putConstraint(SpringLayout.EAST, exitButton, -5, SpringLayout.EAST, topPanel);
        layout.putConstraint(SpringLayout.NORTH, exitButton, 5, SpringLayout.NORTH, topPanel);
    }

    private void initGameTilePanel() {

        gameTileContainer.setLayout(new GridLayout(0, 5, 5, 5));
        for (GameTile gameTile : GameTileParser.toGameTiles()) {
            gameTile.setPreferredSize(new Dimension(getFrameWidth() / 6, getFrameHeight() / 3));
            gameTileContainer.add(gameTile);
        }

        scrollPane = new JScrollPane(gameTileContainer);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    }

    private void initButtonsBarPanel() {

    }

    private void setActionListeners() {
        exitMenuItem.addActionListener(ButtonActionEvents.exitButtonAction());
        gameDetectionMenuItem.addActionListener(ButtonActionEvents.gameDetectionAction());
        aboutMenuItem.addActionListener(ButtonActionEvents.aboutAction());
        exitButton.addActionListener(ButtonActionEvents.exitButtonAction());
    }

    private void initOptionsBar() {
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

    public JPanel getGameTileInfoContainer() {
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
