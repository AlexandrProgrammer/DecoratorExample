package org.example;

import org.example.ui.OrderFrame;

import javax.swing.SwingUtilities;

public class Main {
     static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrderFrame().setVisible(true));
    }
}