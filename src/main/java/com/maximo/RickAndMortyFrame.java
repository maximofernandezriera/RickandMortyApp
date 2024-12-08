package com.maximo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RickAndMortyFrame extends JFrame {

    private final RickAndMortyService service;
    private final CharacterTableModel tableModel;
    private int currentPage = 1;
    private int totalPages = 1;

    private JButton firstButton;
    private JButton prevButton;
    private JButton nextButton;
    private JButton lastButton;
    private JLabel pageLabel;
    private JTable characterTable;

    public RickAndMortyFrame() {
        service = new RickAndMortyService();
        tableModel = new CharacterTableModel();

        setTitle("Rick and Morty Characters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        characterTable = new JTable(tableModel);
        characterTable.setRowHeight(60); // Increment row height to fit images.
        add(new JScrollPane(characterTable), BorderLayout.CENTER);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        firstButton = new JButton("Primera Página");
        prevButton = new JButton("Anterior");
        nextButton = new JButton("Siguiente");
        lastButton = new JButton("Última Página");
        pageLabel = new JLabel("Página: " + currentPage);

        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = 1;
                loadData();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    loadData();
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    loadData();
                }
            }
        });

        lastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = totalPages;
                loadData();
            }
        });

        navPanel.add(firstButton);
        navPanel.add(prevButton);
        navPanel.add(pageLabel);
        navPanel.add(nextButton);
        navPanel.add(lastButton);

        add(navPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        loadData();
    }

    private void loadData() {
        try {
            ApiResponse response = service.getCharacters(currentPage);
            tableModel.setCharacters(response.getResults());
            totalPages = response.getInfo().getPages();
            pageLabel.setText("Página: " + currentPage);
            updateButtons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateButtons() {
        firstButton.setEnabled(currentPage > 1);
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);
        lastButton.setEnabled(currentPage < totalPages);
    }
}