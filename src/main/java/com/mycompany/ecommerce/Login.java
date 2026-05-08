package com.mycompany.ecommerce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private static final String ADMIN_USER  = "admin";
    private static final String ADMIN_PASS  = "admin123";
    private static final String CLIENT_USER = "cliente";
    private static final String CLIENT_PASS = "cliente123";


    static final Color BG_CARD    = new Color(20,  20,  28);
    static final Color ACCENT     = new Color(204, 30,  30);
    static final Color ACCENT_HOV = new Color(240, 50,  50);
    static final Color TEXT_PRI   = new Color(245, 245, 245);
    static final Color TEXT_SEC   = new Color(160, 160, 175);
    static final Color BORDER_CLR = new Color(60,  60,  75);

    public Login() {
        setTitle("OtakuStore — Login 🎌");
        setExtendedState(JFrame.MAXIMIZED_BOTH);      // pantalla completa
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtener tamaño real de la pantalla
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int W = screen.width;
        int H = screen.height;

        // Medidas de la tarjeta
        int cardW = 400;
        int cardH = 310;
        int cardX = (W - cardW) / 2;   // centrado horizontal
        int cardY = (H - cardH) / 2;   // centrado vertical

        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(
                    0, 0,           new Color(14, 14, 20),
                    0, getHeight(), new Color(6,  6,  10));
                g2.setPaint(gp);
                g2.fillRect(0, 0, getWidth(), getHeight());
                // Línea roja centrada verticalmente encima del formulario
                g2.setColor(ACCENT);
                g2.setStroke(new BasicStroke(3f));
                g2.drawLine(0, cardY - 80, getWidth(), cardY - 80);
                g2.dispose();
            }
        };
        panel.setOpaque(true);

        // ── Logo ──────────────────────────────────────────────────────────
        JLabel logo = new JLabel("⛩");
        logo.setBounds(0, cardY - 155, W, 55);
        logo.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 44));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(logo);

        // ── Título ────────────────────────────────────────────────────────
        JLabel titulo = new JLabel("OTAKU STORE");
        titulo.setBounds(0, cardY - 95, W, 50);
        titulo.setForeground(TEXT_PRI);
        titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 42));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        // ── Subtítulo ─────────────────────────────────────────────────────
        JLabel subtitulo = new JLabel("Inicia sesión para continuar");
        subtitulo.setBounds(0, cardY - 36, W, 22);
        subtitulo.setForeground(TEXT_SEC);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitulo);

        // ── Tarjeta centrada ──────────────────────────────────────────────
        JPanel card = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(BG_CARD);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 16, 16);
                g2.setColor(BORDER_CLR);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 16, 16);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setBounds(cardX, cardY, cardW, cardH);
        panel.add(card);

        // ── Campo Usuario ─────────────────────────────────────────────────
        JLabel lblUser = new JLabel("Usuario");
        lblUser.setBounds(20, 20, 360, 18);
        lblUser.setForeground(TEXT_SEC);
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 11));
        card.add(lblUser);

        JTextField txtUser = new JTextField();
        txtUser.setBounds(20, 40, 360, 42);
        txtUser.setBackground(new Color(30, 30, 40));
        txtUser.setForeground(TEXT_PRI);
        txtUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUser.setCaretColor(TEXT_PRI);
        txtUser.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_CLR, 1),
            BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));
        card.add(txtUser);

        // ── Campo Contraseña ──────────────────────────────────────────────
        JLabel lblPass = new JLabel("Contraseña");
        lblPass.setBounds(20, 100, 360, 18);
        lblPass.setForeground(TEXT_SEC);
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 11));
        card.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(20, 120, 360, 42);
        txtPass.setBackground(new Color(30, 30, 40));
        txtPass.setForeground(TEXT_PRI);
        txtPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPass.setCaretColor(TEXT_PRI);
        txtPass.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_CLR, 1),
            BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));
        card.add(txtPass);

        // ── Mensaje error ─────────────────────────────────────────────────
        JLabel lblError = new JLabel("");
        lblError.setBounds(20, 170, 360, 18);
        lblError.setForeground(new Color(255, 80, 80));
        lblError.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblError.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(lblError);

        // ── Botón ingresar ────────────────────────────────────────────────
        JButton btnLogin = new JButton("INGRESAR") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (getModel().isPressed())       g2.setColor(new Color(150, 15, 15));
                else if (getModel().isRollover()) g2.setColor(ACCENT_HOV);
                else                              g2.setColor(ACCENT);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btnLogin.setBounds(20, 200, 360, 48);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        card.add(btnLogin);

        // ── Hint ──────────────────────────────────────────────────────────
        JLabel hint = new JLabel("admin / admin123  ·  cliente / cliente123");
        hint.setBounds(0, cardY + cardH + 20, W, 18);
        hint.setForeground(new Color(80, 80, 95));
        hint.setFont(new Font("Consolas", Font.PLAIN, 11));
        hint.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(hint);

        // ── Lógica login ──────────────────────────────────────────────────
        ActionListener loginAction = e -> {
            String user = txtUser.getText().trim();
            String pass = new String(txtPass.getPassword()).trim();

            if (user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)) {
                dispose();
                VentanaTienda.iniciar("admin");

            } else if (user.equals(CLIENT_USER) && pass.equals(CLIENT_PASS)) {
                dispose();
                VentanaTienda.iniciar("cliente");

            } else {
                lblError.setText("⚠  Usuario o contraseña incorrectos");
                txtPass.setText("");
                txtUser.selectAll();
                txtUser.requestFocus();
            }
        };

        btnLogin.addActionListener(loginAction);
        txtUser.addActionListener(loginAction);
        txtPass.addActionListener(loginAction);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}