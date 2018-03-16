/*

 */

package org.coincoop.tradeimporter.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

    JMenuBar getMenuBar() {
        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getFileMenu());
        menuBar.add(getHelpMenu());

        return menuBar;
    }

    private JMenu getFileMenu() {
        JMenu menu = new JMenu("FILE");

        JMenuItem menuItemOpen = new JMenuItem("Open");
        JMenuItem menuItemSaveAs = new JMenuItem("Save as");
        menu.add(menuItemOpen);
        menu.add(menuItemSaveAs);

        return menu;
    }

    private JMenu getHelpMenu() {
        JMenu menu = new JMenu("Help");

        JMenuItem menuItemAbout = new JMenuItem("About...");
        menu.add(menuItemAbout);

        return menu;
    }
}
