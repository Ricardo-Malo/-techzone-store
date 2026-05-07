package com.mycompany.ecommerce;

import javax.swing.*;
import java.awt.*;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");

        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBounds(0, 0, 400, 300);

        panel.setBackground(Color.BLACK);


        JLabel titulo = new JLabel("OTAKU LOGIN");

        titulo.setBounds(80, 20, 300, 40);

        titulo.setForeground(Color.WHITE);

        titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 28));

        panel.add(titulo);

       

        JLabel userLabel = new JLabel("Usuario:");

        userLabel.setBounds(40, 90, 100, 30);

        userLabel.setForeground(Color.WHITE);

        userLabel.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(userLabel);

        JTextField usuario = new JTextField();

        usuario.setBounds(150, 90, 180, 30);

        panel.add(usuario);

        

        JLabel passLabel = new JLabel("Contraseña:");

        passLabel.setBounds(40, 140, 120, 30);

        passLabel.setForeground(Color.WHITE);

        passLabel.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(passLabel);

        JPasswordField password = new JPasswordField();

        password.setBounds(150, 140, 180, 30);

        panel.add(password);

       

        JButton login = new JButton("Ingresar 🔥");

        login.setBounds(120, 200, 150, 40);

        panel.add(login);

       

        login.addActionListener(e -> {

            String user = usuario.getText();

            String pass = new String(password.getPassword());

            if (user.equals("admin") && pass.equals("1234")) {

                JOptionPane.showMessageDialog(null, "Bienvenido 😎");

                frame.dispose();

                VentanaTienda.main(new String[0]);

            } else {

                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos ❌");

            }

        });

        frame.add(panel);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}