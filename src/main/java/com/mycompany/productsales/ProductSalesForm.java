/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsales;

/**
 *
 * @author deepl
 */
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductSalesForm extends JFrame {

    private JButton btnLoad;
    private JButton btnSave;

    private JTextArea txtDisplay;

    private JLabel lblYearsProcessed;

    private JMenuItem mnuExit;
    private JMenuItem mnuLoad;
    private JMenuItem mnuSave;
    private JMenuItem mnuClear;

    private ProductSales sales;

    public ProductSalesForm() {

        sales = new ProductSales();

        initializeGUI();
    }

    private void initializeGUI() {

        setTitle("Product Sales Application");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        mnuExit = new JMenuItem("Exit");

        mnuLoad = new JMenuItem("Load Product Data");
        mnuSave = new JMenuItem("Save Product Data");
        mnuClear = new JMenuItem("Clear");

        fileMenu.add(mnuExit);

        toolsMenu.add(mnuLoad);
        toolsMenu.add(mnuSave);
        toolsMenu.add(mnuClear);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        btnLoad = new JButton("Load Product Data");
        btnSave = new JButton("Save Product Data");

        txtDisplay = new JTextArea(8, 25);
        txtDisplay.setEditable(false);

        lblYearsProcessed = new JLabel("Years Processed:");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(btnLoad);
        panel.add(btnSave);
        panel.add(new JScrollPane(txtDisplay));
        panel.add(lblYearsProcessed);

        add(panel);

        btnLoad.addActionListener(e -> loadProductData());

        btnSave.addActionListener(e -> saveProductData());

        mnuLoad.addActionListener(e -> loadProductData());

        mnuSave.addActionListener(e -> saveProductData());

        mnuClear.addActionListener(e -> clearData());

        mnuExit.addActionListener(e -> System.exit(0));
    }

    private void loadProductData() {

        String output =
                "Total Sales: " + sales.GetTotalSales()
                + "\nAverage Sales: "
                + Math.round(sales.GetAverageSales())
                + "\nSales over limit: "
                + sales.GetSalesOverLimit()
                + "\nSales under limit: "
                + sales.GetSalesUnderLimit();

        txtDisplay.setText(output);

        lblYearsProcessed.setText(
                "Years Processed: "
                + sales.GetProductsProcessed());
    }

    private void saveProductData() {

        try {

            FileWriter writer =
                    new FileWriter("data.txt");

            writer.write("DATA LOG\n");
            writer.write("********************************\n");
            writer.write(txtDisplay.getText() + "\n");
            writer.write("********************************\n");

            writer.close();

            JOptionPane.showMessageDialog(
                    this,
                    "Data saved successfully."
            );

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error saving file."
            );
        }
    }

    private void clearData() {

        txtDisplay.setText("");

        lblYearsProcessed.setText(
                "Years Processed:");
    }
}