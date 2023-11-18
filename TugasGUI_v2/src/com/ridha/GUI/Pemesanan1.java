package com.ridha.GUI;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pemesanan1 extends JFrame {
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panel5;
    private JPanel Panel4;
    private JTextField textNama;
    private JTextField textAlamat;
    private JTextField textNoTelp;
    private JCheckBox steakCheckBox;
    private JCheckBox spaghettiCheckBox;
    private JCheckBox pizzaCheckBox;
    private JTextField textField1;
    private JButton tambahButton;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JEditorPane editorPane1;

    private double total = 0.0;

    public Pemesanan1(){
        setContentPane(Panel1);
        setTitle("Aplikasi Pemesanan Makanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

        steakCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (steakCheckBox.isSelected()) {
                    total += 20000.0;
                    textField1.setText(String.valueOf(total));
                }else {
                    total -= 20000.0;
                    textField1.setText(String.valueOf(total));
                }

                if (total < 0.0) {
                    total = 0.0;
                    textField1.setText(String.valueOf(total));
                }
            }
        });


        spaghettiCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (spaghettiCheckBox.isSelected()) {
                    total += 8000.0;
                    textField1.setText(String.valueOf(total));
                }else {
                    total -= 8000.0;
                    textField1.setText(String.valueOf(total));
                }

                if (total < 0.0) {
                    total = 0.0;
                    textField1.setText(String.valueOf(total));
                }
            }
        });

        pizzaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pizzaCheckBox.isSelected()) {
                    total += 15000.0;
                    textField1.setText(String.valueOf(total));
                }else {
                    total -= 15000.0;
                    textField1.setText(String.valueOf(total));
                }

                if (total < 0.0) {
                    total = 0.0;
                    textField1.setText(String.valueOf(total));
                }
            }
        });

        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();

                JOptionPane.showMessageDialog(null, "Pesanan Berhasil!", "Info", JOptionPane.INFORMATION_MESSAGE);

                StringBuilder orderDetails = new StringBuilder();

                if (steakCheckBox.isSelected()) {
                    orderDetails.append("\t- ").append("Steak").append(" (20000.0)\n");
                }

                if (spaghettiCheckBox.isSelected()) {
                    orderDetails.append("\t- ").append("Spaghetti").append(" (8000.0)\n");
                }

                if (pizzaCheckBox.isSelected()) {
                    orderDetails.append("\t- ").append("Pizza").append(" (15000.0)\n");
                }

                String dash = "=================================\n";

                String textContent1 = "Nama: " + textNama.getText() + "\nAlamat: " + textAlamat.getText() + "\n" + "No Telp: " + textNoTelp.getText() + "\n" ;
                String textContent2 = "Pesanan: \n" + orderDetails.toString();
                String textContent3 = "Total Bayar: " + "\n\t" + "Rp." + total;
                textArea1.setText(textContent1 + dash + textContent2 + dash + textContent3);

            }
        });

    }

    public static void main(String[] args) {
        new Pemesanan1();
    }
}
