/*

 */

package org.coincoop.tradeimporter.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.coincoop.tradeimporter.view.application.Panel;

public class View extends JFrame {

    public void initUI() {
        Menu menu = new Menu();
        Panel panel = new Panel();

        createLayout(menu.getMenuBar(), panel.getMiddlePanel(), panel.getBottomPanel());

        setTitle("Coin Trade Importer - KuCoin - CoinTracking CSV Downloader");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {
        Container pane = getContentPane();

        //Adding Components to the frame.
        pane.add(BorderLayout.NORTH, arg[0]);
        pane.add(BorderLayout.CENTER, arg[1]);
        pane.add(BorderLayout.SOUTH, arg[2]);
    }
}
