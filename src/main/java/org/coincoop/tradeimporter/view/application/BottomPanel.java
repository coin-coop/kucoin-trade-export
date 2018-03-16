/*

 */

package org.coincoop.tradeimporter.view.application;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomPanel {

    JPanel getBottomPanel() {
        JPanel mainPanel = new JPanel();

        FlowLayout flowLayout = new FlowLayout((FlowLayout.LEADING));
        mainPanel.setLayout(flowLayout);

        JPanel panel = new JPanel();

        GridLayout gridLayout = new GridLayout(1,4);

        panel.setLayout(gridLayout);
        panel.add(getQuitButton());
        mainPanel.add(panel);

        return mainPanel;
    }

    private JButton getQuitButton() {
        JButton quitButton = new JButton("Exit");

        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        return quitButton;
    }
}
