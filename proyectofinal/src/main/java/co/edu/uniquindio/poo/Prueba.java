package co.edu.uniquindio.poo;

import javax.swing.*;

public class Prueba {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ejemplo ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(40, 300);

            JLabel label = new JLabel("¡Hola, Swing!", SwingConstants.CENTER);
            frame.add(label);

            frame.setVisible(true);
        });
    }
}

