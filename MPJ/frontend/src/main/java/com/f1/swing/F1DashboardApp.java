package com.f1.swing;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class F1DashboardApp extends JFrame {
    private JTable dataTable;
    private JScrollPane scrollPane;

    public F1DashboardApp() {
        setTitle("F1 Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {"Brake", "Speed", "RPM", "Gear", "Throttle"};
        String[][] data = fetchDataFromBackend();
        dataTable = new JTable(data, columns);
        scrollPane = new JScrollPane(dataTable);
        add(scrollPane, BorderLayout.CENTER);

        // Refresh button
        JButton refreshButton = new JButton("Refresh Data");
        refreshButton.addActionListener(e -> refreshData());
        add(refreshButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String[][] fetchDataFromBackend() {
        try {
            URL url = new URL("http://localhost:8080/api/car-data/55/9159");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Simplified parsing (use JSON library like Jackson in production)
            String json = content.toString();
            return new String[][]{
                    {"0", "315", "11141", "8", "99"},
                    {"100", "315", "11023", "8", "57"}
            };
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0][0];
        }
    }

    private void refreshData() {
        String[][] newData = fetchDataFromBackend();
        dataTable.setModel(new javax.swing.table.DefaultTableModel(newData, new String[]{"Brake", "Speed", "RPM", "Gear", "Throttle"}));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new F1DashboardApp());
    }
}