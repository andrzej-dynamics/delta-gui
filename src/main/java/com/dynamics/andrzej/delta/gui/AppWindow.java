package com.dynamics.andrzej.delta.gui;

import javax.swing.*;

/**
 * Created by jazowski_1150904 on 08.10.18.
 */
public class AppWindow extends JFrame {
    private JTextField heheheheTextField;
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton obliczButton;
    private JLabel result;


    public void launchApp() {
        JFrame f = new JFrame();
        f.add(this.panel1);

        f.setSize(800, 500);
        f.setVisible(true);

    }
}
