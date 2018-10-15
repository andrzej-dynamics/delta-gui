package com.dynamics.andrzej.delta.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jazowski_1150904 on 08.10.18.
 */
public class AppWindow extends JFrame implements ActionListener {
    private static final String INAPPROPRIATE_VALUE_MESSAGE = "Niepoprawna wartość pola!";
    private JPanel panel1;
    private JTextField aTextFiled;
    private JTextField bTextFiled;
    private JTextField cTextFiled;
    private JButton obliczButton;
    private JLabel resultLabel;


    public void launchApp() {
        JFrame f = new JFrame();
        f.add(this.panel1);

        obliczButton.addActionListener(this);

        f.setSize(800, 500);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        try {
            double result = calculate(aTextFiled.getText(), bTextFiled.getText(), cTextFiled.getText());
            resultLabel.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            resultLabel.setText(INAPPROPRIATE_VALUE_MESSAGE);
        }
    }

    private double calculate(String aText, String bText, String cText) {
        try {
            double a = Double.parseDouble(aText);
            double b = Double.parseDouble(bText);
            double c = Double.parseDouble(cText);
            return Delta.calculateDelta(b, a, c);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
