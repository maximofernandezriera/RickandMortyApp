package com.maximo;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RickAndMortyFrame frame = new RickAndMortyFrame();
            frame.setVisible(true);
        });
    }
}
