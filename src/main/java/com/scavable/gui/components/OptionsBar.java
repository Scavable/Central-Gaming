package com.scavable.gui.components;

import com.scavable.gui.actions.ButtonActionEvents;

import javax.swing.*;

public class OptionsBar extends JMenuBar{
    protected JMenuItem exitMenuItem = new JMenuItem("Exit");
    protected JMenuItem sortAsc = new JMenuItem("Ascending");
    protected JMenuItem sortDesc = new JMenuItem("Descending");
    protected JMenuItem sortRecent = new JMenuItem("Recent");
    protected JMenuItem sortOldest = new JMenuItem("Oldest");
    protected JMenuItem aboutMenuItem = new JMenuItem("About");
    protected JMenuItem gameDetectionMenuItem = new JMenuItem("Game Detection");
    public JMenuBar OptionsBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu sortMenu = new JMenu("Sort");
        JMenu customizeMenu = new JMenu("Customize");

        sortAsc.addActionListener(ButtonActionEvents.sortAscendingAction());
        sortDesc.addActionListener(ButtonActionEvents.sortDescendingAction());
        sortRecent.addActionListener(ButtonActionEvents.sortRecent());
        sortOldest.addActionListener(ButtonActionEvents.sortOldest());

        add(fileMenu);
        add(editMenu);
        add(sortMenu);
        add(customizeMenu);

        fileMenu.add(exitMenuItem);

        editMenu.add(gameDetectionMenuItem);

        sortMenu.add(sortAsc);
        sortMenu.add(sortDesc);
        sortMenu.add(sortRecent);
        sortMenu.add(sortOldest);

        add(aboutMenuItem);

        return this;
    }

    public JMenuBar getOptionsBar() {
        return this;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public void setExitMenuItem(JMenuItem exitMenuItem) {
        this.exitMenuItem = exitMenuItem;
    }

    public JMenuItem getSortAsc() {
        return sortAsc;
    }

    public void setSortAsc(JMenuItem sortAsc) {
        this.sortAsc = sortAsc;
    }

    public JMenuItem getSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(JMenuItem sortDesc) {
        this.sortDesc = sortDesc;
    }

    public JMenuItem getSortRecent() {
        return sortRecent;
    }

    public void setSortRecent(JMenuItem sortRecent) {
        this.sortRecent = sortRecent;
    }

    public JMenuItem getSortOldest() {
        return sortOldest;
    }

    public void setSortOldest(JMenuItem sortOldest) {
        this.sortOldest = sortOldest;
    }

    public JMenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public void setAboutMenuItem(JMenuItem aboutMenuItem) {
        this.aboutMenuItem = aboutMenuItem;
    }

    public JMenuItem getGameDetectionMenuItem() {
        return gameDetectionMenuItem;
    }

    public void setGameDetectionMenuItem(JMenuItem gameDetectionMenuItem) {
        this.gameDetectionMenuItem = gameDetectionMenuItem;
    }
}
