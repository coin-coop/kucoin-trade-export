/*

 */

package org.coincoop.kucointradeexport.view.application;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.coincoop.kucointradeexport.controller.ImporterWorker;

public class MiddlePanel extends JPanel {

    private File path;
    private JLabel emptyLabel;
    private JLabel emptyLabel2;
    private JLabel emptyLabel3;
    private JLabel apiKeyLabel;
    private JTextField apiKeyTextField;
    private JLabel secretKeyLabel;
    private JTextField seretKeyTextField;
    private JLabel infoLabel;
    private JButton importButton;
    private JButton chooseLocationButton;
    private JScrollPane infoScrollPane;
    private JTextArea infoTextArea;
    private JFileChooser fileChooser;

    public MiddlePanel() {
        initComponents();
    }

    private void initComponents() {
        emptyLabel = new JLabel();
        emptyLabel2 = new JLabel();
        emptyLabel3 = new JLabel();
        apiKeyLabel = new JLabel();
        apiKeyTextField = new JTextField();
        secretKeyLabel = new JLabel();
        seretKeyTextField = new JTextField();
        infoLabel = new JLabel();
        chooseLocationButton = new JButton();
        importButton = new JButton();
        infoScrollPane = new JScrollPane();
        infoTextArea = new JTextArea();
        fileChooser = new JFileChooser();

        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        add(emptyLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        add(emptyLabel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

        //---- apiKeyLabel ----
        apiKeyLabel.setText(" API Key:");
        add(apiKeyLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        add(apiKeyTextField, new GridBagConstraints(4, 1, 8, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));

        //---- secretKeyLabel ----
        secretKeyLabel.setText(" Secret Key:");
        add(secretKeyLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        add(seretKeyTextField, new GridBagConstraints(4, 2, 8, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));

        //---- infoLabel ----
        infoLabel.setText(" Note: Download of data can take a while, so please wait. Use Ctrl+V / Strg+V to paste.");
        add(infoLabel, new GridBagConstraints(1, 3, 5, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

        //---- chooseLocationButton ----
        chooseLocationButton.setText("Choose location");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter(
                "csv files (*.csv)", "csv");
        fileChooser.setFileFilter(csvFilter);
        add(chooseLocationButton, new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        chooseLocationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (fileChooser.showSaveDialog(MiddlePanel.this)) {
                    case JFileChooser.APPROVE_OPTION:
                        path = fileChooser.getSelectedFile();
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    case JFileChooser.ERROR_OPTION:
                        JOptionPane.showMessageDialog(MiddlePanel.this, "Error",
                                "Coin Trade Importer", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //---- importButton ----
        importButton.setText("Download CSV");
        add(importButton, new GridBagConstraints(7, 4, 5, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImporterWorker importerWorker = new ImporterWorker(apiKeyTextField.getText(), seretKeyTextField.getText(), infoTextArea, path);
                importerWorker.execute();
            }
        });

        add(emptyLabel3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

        //======== infoScrollPane ========
        {

            //---- infoTextArea ----
            infoTextArea.setRows(8);
            infoScrollPane.setViewportView(infoTextArea);
        }
        add(infoScrollPane, new GridBagConstraints(1, 5, 11, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }
}
