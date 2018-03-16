package org.coincoop.tradeimporter;

import org.coincoop.tradeimporter.view.View;

public class CoinTradeImporterApp {

    private static void createAndShowGUI() {
        View view = new View();
        view.setVisible(true);
        view.initUI();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
