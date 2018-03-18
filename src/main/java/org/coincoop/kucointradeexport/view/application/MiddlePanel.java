/*

 */

package org.coincoop.kucointradeexport.view.application;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.optionalusertools.DateChangeListener;
import com.github.lgooddatepicker.zinternaltools.DateChangeEvent;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;

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

class MiddlePanel extends JPanel {

    private File path;
    private LocalDate sinceLocalDate;
    private LocalDate beforeLocalDate;
    private JLabel emptyLabel;
    private JLabel emptyLabel2;
    private JLabel apiKeyLabel;
    private JTextField apiKeyTextField;
    private JLabel secretKeyLabel;
    private JTextField secretKeyTextField;
    private JLabel datePickerBeforeLabel;
    private DatePicker datePickerBefore;
    private JLabel datePickerSinceLabel;
    private DatePicker datePickerSince;
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
        apiKeyLabel = new JLabel();
        apiKeyTextField = new JTextField();
        secretKeyLabel = new JLabel();
        secretKeyTextField = new JTextField();
        infoLabel = new JLabel();
        datePickerBeforeLabel = new JLabel();
        datePickerBefore = new DatePicker();
        datePickerSinceLabel = new JLabel();
        datePickerSince = new DatePicker();
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
        add(secretKeyTextField, new GridBagConstraints(4, 2, 8, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));

        //---- datePickerSinceLabel ----
        datePickerSinceLabel.setText("Start date:");
        add(datePickerSinceLabel, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        add(datePickerSince, new GridBagConstraints(4, 4, 4, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));
        datePickerSince.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent dateChangeEvent) {
                sinceLocalDate = datePickerSince.getDate();
            }
        });

        //---- datePickerSinceLabel ----
        datePickerBeforeLabel.setText("End date:");
        add(datePickerBeforeLabel, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));
        add(datePickerBefore, new GridBagConstraints(4, 3, 4, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));
        datePickerBefore.addDateChangeListener(new DateChangeListener() {
            @Override
            public void dateChanged(DateChangeEvent dateChangeEvent) {
                beforeLocalDate = datePickerBefore.getDate();
            }
        });

        //---- infoLabel ----
        infoLabel.setText(" Note: Download of data can take a while, so please wait. Use Ctrl+V / Strg+V to paste.");
        add(infoLabel, new GridBagConstraints(1, 5, 5, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 7), 0, 0));

        //---- chooseLocationButton ----
        chooseLocationButton.setText("Choose location");
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter(
                "csv files (*.csv)", "csv");
        fileChooser.setFileFilter(csvFilter);
        add(chooseLocationButton, new GridBagConstraints(1, 6, 3, 1, 0.0, 0.0,
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
        add(importButton, new GridBagConstraints(7, 6, 5, 1, 0.0, 0.0,
                GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 7, 0), 0, 0));
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImporterWorker importerWorker = new ImporterWorker(apiKeyTextField.getText(), secretKeyTextField.getText(),
                        infoTextArea, path, beforeLocalDate, sinceLocalDate);
                importerWorker.execute();
            }
        });

        //======== infoScrollPane ========
        {
            //---- infoTextArea ----
            infoTextArea.setRows(8);
            infoScrollPane.setViewportView(infoTextArea);
        }
        add(infoScrollPane, new GridBagConstraints(1, 7, 11, 4, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }
}
