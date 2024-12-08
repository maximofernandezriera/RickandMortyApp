package com.maximo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CharacterTableModel extends AbstractTableModel {
    private final String[] columnNames = { "ID", "Nombre", "Estado", "Especie", "Imagen" };
    private List<Character> characters = new ArrayList<>();

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return characters.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Character character = characters.get(rowIndex);
        switch (columnIndex) {
            case 0: return character.getId();
            case 1: return character.getName();
            case 2: return character.getStatus();
            case 3: return character.getSpecies();
            case 4: 
                try {
                    URL url = new URL(character.getImage());
                    Image image = ImageIO.read(url);
                    Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                    return new ImageIcon(scaledImage);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return ImageIcon.class;
        }
        return String.class;
    }
}