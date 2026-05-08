package com.mycompany.ecommerce;

import com.mycompany.database.Conexion;
import com.mycompany.molde.*;
import com.mycompany.service.ProductoService;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaTienda {

    // ── Paleta OtakuStore ──────────────────────────────────────────────────
    static final Color BG_DEEP    = new Color(10,  10,  14);
    static final Color BG_CARD    = new Color(20,  20,  28);
    static final Color ACCENT     = new Color(204, 30,  30);
    static final Color ACCENT_HOV = new Color(240, 50,  50);
    static final Color TEXT_PRI   = new Color(245, 245, 245);
    static final Color TEXT_SEC   = new Color(160, 160, 175);
    static final Color BORDER_CLR = new Color(60,  60,  75);

    // ── Tipografías ────────────────────────────────────────────────────────
    static final Font FONT_TITLE  = new Font("Segoe UI Black", Font.BOLD,   38);
    static final Font FONT_SUB    = new Font("Segoe UI",       Font.PLAIN,  13);
    static final Font FONT_BTN    = new Font("Segoe UI Semibold", Font.BOLD, 13);
    static final Font FONT_PROD   = new Font("Segoe UI",       Font.BOLD,   12);
    static final Font FONT_CART   = new Font("Consolas",       Font.PLAIN,  12);
    static final Font FONT_TOTAL  = new Font("Segoe UI Black", Font.BOLD,   16);

    // ── Colores por tarjeta ────────────────────────────────────────────────
    static final Color[] PROD_COLORS = {
        new Color(180,  25,  25),
        new Color(140,  20,  20),
        new Color(165,  22,  22),
        new Color(195,  28,  28),
        new Color(155,  18,  18)
    };

    // ── Entrada por defecto ────────────────────────────────────────────────
    public static void main(String[] args) {
        iniciar("cliente");
    }

    // ── Método principal con rol ───────────────────────────────────────────
    public static void iniciar(String rol) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        Conexion.conectar();
        Conexion.crearTabla();
        Conexion.insertarProducto("Figura Naruto",       50);
        Conexion.insertarProducto("Manga One Piece",     20);
        Conexion.insertarProducto("Cosplay Nezuko",      80);
        Conexion.insertarProducto("Camiseta Anime",      35);
        Conexion.insertarProducto("Llavero Dragon Ball", 10);

        ProductoService service        = new ProductoService();
        ArrayList<Productos> productos = service.obtenerProductos();
        final Carrito[] carrito        = {new Carrito()};

        // ── Ventana principal ──────────────────────────────────────────────
        JFrame ventana = new JFrame("OtakuStore 🎌");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(true);

        // ── Panel raíz ────────────────────────────────────────────────────
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
                g2.setColor(ACCENT);
                g2.setStroke(new BasicStroke(3f));
                g2.drawLine(0, 85, getWidth(), 85);
                g2.dispose();
            }
        };
        panel.setOpaque(true);

        // ── Título ────────────────────────────────────────────────────────
        JLabel titulo = new JLabel("⛩ OTAKU STORE");
        titulo.setBounds(0, 15, 1600, 60);
        titulo.setForeground(TEXT_PRI);
        titulo.setFont(FONT_TITLE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        JLabel subtitulo = new JLabel("Tu tienda de anime favorita");
        subtitulo.setBounds(0, 58, 1600, 24);
        subtitulo.setForeground(TEXT_SEC);
        subtitulo.setFont(FONT_SUB);
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitulo);

        // ── Botones admin (solo visibles si rol == "admin") ────────────────
        boolean esAdmin = rol.equals("admin");

        JButton btnAdmin    = crearBotonAdmin(" Añadir",    new Color(40, 120, 200));
        JButton btnEliminar = crearBotonAdmin("  Eliminar", new Color(180, 30,  30));
        JButton btnEditar   = crearBotonAdmin("  Editar",   new Color(180, 120,  0));
        JButton btnRefresh  = crearBotonAdmin("  Refresh",  new Color(30,  150, 80));
        JButton btnHistorial = crearBotonAdmin("🧾 Historial", new Color(70, 50, 120));

        btnAdmin.setBounds(350, 105, 150, 38);
        btnEliminar.setBounds(515, 105, 150, 38);
        btnEditar.setBounds(680, 105, 150, 38);
        btnRefresh.setBounds(845, 105, 150, 38);
        btnHistorial.setBounds(1010, 105, 150, 38);

        // Admin ve todos los botones, cliente solo ve historial
        btnAdmin.setVisible(esAdmin);
        btnEliminar.setVisible(esAdmin);
        btnEditar.setVisible(esAdmin);
        btnRefresh.setVisible(esAdmin);
        btnHistorial.setVisible(true);  // visible para todos

        panel.add(btnAdmin);
        panel.add(btnEliminar);
        panel.add(btnEditar);
        panel.add(btnRefresh);
        panel.add(btnHistorial);

        // ── Acciones admin ────────────────────────────────────────────────
        btnAdmin.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(null, "Nombre del producto:", "Admin — Agregar", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null || nombre.isBlank()) return;
            String precioTexto = JOptionPane.showInputDialog(null, "Precio:", "Admin — Precio", JOptionPane.PLAIN_MESSAGE);
            if (precioTexto == null) return;
            try {
                double precio = Double.parseDouble(precioTexto);
                Conexion.insertarProducto(nombre, precio);
                JOptionPane.showMessageDialog(null, "✅  Producto agregado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "⚠  Precio inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(null, "Nombre del producto a eliminar:", "Eliminar producto", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null || nombre.isBlank()) return;
            Conexion.eliminarProducto(nombre);
            JOptionPane.showMessageDialog(null, "🗑  Producto eliminado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
        });

        btnEditar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(null, "Producto a editar:", "Editar producto", JOptionPane.PLAIN_MESSAGE);
            if (nombre == null || nombre.isBlank()) return;
            String precioTexto = JOptionPane.showInputDialog(null, "Nuevo precio:", "Nuevo precio", JOptionPane.PLAIN_MESSAGE);
            if (precioTexto == null) return;
            try {
                double nuevoPrecio = Double.parseDouble(precioTexto);
                Conexion.actualizarPrecio(nombre, nuevoPrecio);
                JOptionPane.showMessageDialog(null, "✏  Precio actualizado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "⚠  Precio inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnRefresh.addActionListener(e -> { ventana.dispose(); iniciar(rol); });

        // ── Botón historial ────────────────────────────────────────────────
        btnHistorial.addActionListener(e -> new Historial(rol, rol));

        // ── Sección catálogo ───────────────────────────────────────────────
        JLabel secProductos = new JLabel("CATÁLOGO");
        secProductos.setBounds(60, 165, 300, 28);
        secProductos.setForeground(ACCENT);
        secProductos.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        panel.add(secProductos);

        // ── Tarjetas de productos ──────────────────────────────────────────
        int y = 205, x = 60, contador = 0, colorIdx = 0;

        for (Productos p : productos) {
            final Color cardColor = PROD_COLORS[colorIdx % PROD_COLORS.length];
            colorIdx++;

            JPanel card = new JPanel(null) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(BG_CARD);
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);
                    g2.setColor(cardColor);
                    g2.setStroke(new BasicStroke(2f));
                    g2.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 14, 14);
                    g2.fillRoundRect(0, 0, getWidth(), 6, 14, 14);
                    g2.fillRect(0, 3, getWidth(), 6);
                    g2.dispose();
                }
            };
            card.setOpaque(false);
            card.setBounds(x, y, 290, 110);

            // ── Imagen con fallback a emoji ────────────────────────────────
            JLabel imgLabel = cargarImagenProducto(p.getNombre());
            imgLabel.setBounds(10, 16, 42, 42);
            card.add(imgLabel);

            JLabel nombre = new JLabel(p.getNombre());
            nombre.setBounds(58, 16, 220, 22);
            nombre.setForeground(TEXT_PRI);
            nombre.setFont(FONT_PROD);
            card.add(nombre);

            JLabel precio = new JLabel("$" + (int)p.getPrecio() + " USD");
            precio.setBounds(58, 38, 220, 18);
            precio.setForeground(new Color(100, 220, 100));
            precio.setFont(new Font("Segoe UI", Font.BOLD, 12));
            card.add(precio);

            JButton btn = new JButton("🛒  Agregar al carrito");
            btn.setBounds(12, 68, 265, 32);
            btn.setBackground(cardColor);
            btn.setForeground(Color.WHITE);
            btn.setFont(FONT_BTN);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) { btn.setBackground(ACCENT_HOV); }
                public void mouseExited(MouseEvent e)  { btn.setBackground(cardColor);  }
            });
            btn.addActionListener(e -> {
                carrito[0].agregar(p);
                actualizarCarrito(carrito[0], null, null);
            });
            card.add(btn);
            panel.add(card);

            y += 125; contador++;
            if (contador == 5) { contador = 0; y = 205; x += 320; }
        }

        // ── Panel carrito ──────────────────────────────────────────────────
        JPanel carritoPanel = new JPanel(null) {
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
        carritoPanel.setOpaque(false);
        carritoPanel.setBounds(1000, 165, 370, 420);

        JLabel carritoTitulo = new JLabel("🛒  MI CARRITO");
        carritoTitulo.setBounds(16, 14, 340, 26);
        carritoTitulo.setForeground(TEXT_PRI);
        carritoTitulo.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        carritoPanel.add(carritoTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(12, 44, 346, 2);
        sep.setForeground(BORDER_CLR);
        carritoPanel.add(sep);

        JTextArea area = new JTextArea();
        area.setBackground(new Color(15, 15, 20));
        area.setForeground(new Color(200, 210, 220));
        area.setFont(FONT_CART);
        area.setEditable(false);
        area.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        area.setCaretColor(TEXT_PRI);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(12, 50, 346, 280);
        scroll.setBorder(BorderFactory.createLineBorder(BORDER_CLR, 1));
        scroll.getViewport().setBackground(new Color(15, 15, 20));
        carritoPanel.add(scroll);

        JLabel total = new JLabel("Total: $0");
        total.setBounds(12, 340, 346, 30);
        total.setForeground(new Color(100, 220, 100));
        total.setFont(FONT_TOTAL);
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        carritoPanel.add(total);

        // ── Botón pagar ────────────────────────────────────────────────────
        JButton pagar = new JButton("💳  PAGAR AHORA") {
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
        pagar.setBounds(12, 378, 346, 38);
        pagar.setForeground(Color.WHITE);
        pagar.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        pagar.setFocusPainted(false);
        pagar.setBorderPainted(false);
        pagar.setContentAreaFilled(false);
        pagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // ── Acción pagar con registro en historial ─────────────────────────
        pagar.addActionListener(e -> {
            if (carrito[0].total() == 0) {
                JOptionPane.showMessageDialog(null, "⚠  El carrito está vacío.", "Carrito vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Guardar en historial antes de limpiar
            String resumen = carrito[0].mostrar() +
                "\n──────────────────────────────\n" +
                "Total: $" + carrito[0].total() + "\n" +
                "Método de pago: Tarjeta 💳";
            Historial.registrarCompra(rol, resumen);

            String factura =
                "╔══════════════════════════════╗\n" +
                "║     FACTURA OTAKU STORE ⛩    ║\n" +
                "╠══════════════════════════════╣\n\n" +
                carrito[0].mostrar() +
                "\n──────────────────────────────\n" +
                "Método de pago: Tarjeta 💳\n\n" +
                "¡Gracias por tu compra! 🎌";

            JOptionPane.showMessageDialog(null, factura, "Compra exitosa ✅", JOptionPane.INFORMATION_MESSAGE);
            carrito[0] = new Carrito();
            area.setText("");
            total.setText("Total: $0");
        });

        carritoPanel.add(pagar);
        panel.add(carritoPanel);

        reconnectListeners(panel, productos, carrito, area, total);

        ventana.add(panel);
        ventana.setVisible(true);
    }

    // ── Helpers ───────────────────────────────────────────────────────────

    private static JLabel cargarImagenProducto(String nombre) {
        String slug = nombre.toLowerCase()
                            .replace(" ", "_")
                            .replaceAll("[^a-z0-9_]", "");
        String[] rutas = {
            "resources/images/" + slug + ".png",
            "resources/images/" + slug + ".jpg",
            "resources/images/" + slug + ".jpeg"
        };
        for (String ruta : rutas) {
            java.io.File archivo = new java.io.File(ruta);
            if (archivo.exists()) {
                try {
                    ImageIcon raw    = new ImageIcon(archivo.getAbsolutePath());
                    Image     scaled = raw.getImage()
                                         .getScaledInstance(42, 42, Image.SCALE_SMOOTH);
                    JLabel lbl = new JLabel(new ImageIcon(scaled));
                    lbl.setOpaque(false);
                    return lbl;
                } catch (Exception ignored) {}
            }
        }
        JLabel fallback = new JLabel(getEmoji(nombre));
        fallback.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 26));
        return fallback;
    }

    private static void reconnectListeners(
            JPanel panel, ArrayList<Productos> productos,
            Carrito[] carrito, JTextArea area, JLabel total) {
        for (Component c : panel.getComponents()) {
            if (c instanceof JPanel) {
                JPanel card = (JPanel) c;
                for (Component btn : card.getComponents()) {
                    if (btn instanceof JButton b && b.getText().contains("Agregar")) {
                        int idx = getCardIndex(panel, card);
                        if (idx >= 0 && idx < productos.size()) {
                            Productos p = productos.get(idx);
                            for (ActionListener al : b.getActionListeners()) b.removeActionListener(al);
                            b.addActionListener(e -> {
                                carrito[0].agregar(p);
                                area.setText(carrito[0].mostrar());
                                total.setText("Total: $" + carrito[0].total());
                            });
                        }
                    }
                }
            }
        }
    }

    private static int getCardIndex(JPanel panel, JPanel card) {
        int idx = 0;
        for (Component c : panel.getComponents()) {
            if (c instanceof JPanel p && p != card) {
                for (Component btn : p.getComponents())
                    if (btn instanceof JButton b && b.getText().contains("Agregar")) { idx++; break; }
            } else if (c == card) return idx;
        }
        return -1;
    }

    private static void actualizarCarrito(Carrito c, JTextArea area, JLabel total) {
        // Placeholder: lógica real en reconnectListeners
    }

    private static JButton crearBotonAdmin(String texto, Color color) {
        JButton btn = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color bg = getModel().isPressed()   ? color.darker()   :
                           getModel().isRollover()  ? color.brighter() : color;
                g2.setColor(bg);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setForeground(Color.WHITE);
        btn.setFont(FONT_BTN);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private static String getEmoji(String nombre) {
        String n = nombre.toLowerCase();
        if (n.contains("figura"))   return "🗿";
        if (n.contains("manga"))    return "📖";
        if (n.contains("cosplay"))  return "🎭";
        if (n.contains("camiseta")) return "👕";
        if (n.contains("llavero"))  return "🗝";
        return "🛍";
    }
}