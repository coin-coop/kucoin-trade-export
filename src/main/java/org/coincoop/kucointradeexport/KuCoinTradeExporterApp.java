package org.coincoop.kucointradeexport;

import org.coincoop.kucointradeexport.view.View;

public class KuCoinTradeExporterApp {

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
