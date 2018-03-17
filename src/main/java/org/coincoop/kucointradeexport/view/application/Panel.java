/*

 */

package org.coincoop.kucointradeexport.view.application;

import javax.swing.JPanel;

public class Panel {

    public JPanel getMiddlePanel() {
        return new MiddlePanel();
    }

    public JPanel getBottomPanel() {
        BottomPanel bottomPanel = new BottomPanel();

        return bottomPanel.getBottomPanel();
    }
}
