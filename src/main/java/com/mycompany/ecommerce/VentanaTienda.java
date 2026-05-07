package com.mycompany.ecommerce;

import com.mycompany.database.Conexion;
import com.mycompany.molde.*;
import com.mycompany.service.ProductoService;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaTienda {

    public static void main(String[] args) {

        Conexion.conectar();

        Conexion.crearTabla();

        Conexion.insertarProducto("Figura Naruto", 50);
        Conexion.insertarProducto("Manga One Piece", 20);
        Conexion.insertarProducto("Cosplay Nezuko", 80);
        Conexion.insertarProducto("Camiseta Anime", 35);
        Conexion.insertarProducto("Llavero Dragon Ball", 10);
        ProductoService service = new ProductoService();
        ArrayList<Productos> productos = service.obtenerProductos();

        final Carrito[] carrito = {new Carrito()};

        JFrame ventana = new JFrame("OtakuStore 🎌");
        ventana.setSize(1100, 980);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JLabel titulo = new JLabel("OTAKU STORE");
        titulo.setBounds(360, 30, 500, 50);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Segoe UI Black", Font.BOLD, 34));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo);

        JTextArea area = new JTextArea();
        area.setBounds(320, 620, 450, 170);
        panel.add(area);

        JLabel total = new JLabel("Total: $0");
        total.setBounds(500, 810, 200, 30);
        total.setForeground(Color.WHITE);
        panel.add(total);

        JButton admin = new JButton("Admin ⚙");
        admin.setBounds(230, 120, 170, 45);
        panel.add(admin);
        admin.addActionListener(e -> {

            String nombre = JOptionPane.showInputDialog("Nombre del producto:");

            String precioTexto = JOptionPane.showInputDialog("Precio:");

            double precio = Double.parseDouble(precioTexto);

            Conexion.insertarProducto(nombre, precio);

            JOptionPane.showMessageDialog(null, "Producto agregado 😎");

        });
        JButton eliminar = new JButton("Eliminar ❌");
        eliminar.setBounds(450, 120, 170, 45);
        panel.add(eliminar);

        eliminar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre del producto a eliminar:");
            Conexion.eliminarProducto(nombre);
            JOptionPane.showMessageDialog(null, "Producto eliminado 😎");

        });

        JButton editar = new JButton("Editar ✏");
        editar.setBounds(670, 120, 170, 45);
        panel.add(editar);
        editar.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Producto a editar:");

            String precioTexto = JOptionPane.showInputDialog("Nuevo precio:");

            double nuevoPrecio = Double.parseDouble(precioTexto);

            Conexion.actualizarPrecio(nombre, nuevoPrecio);

            JOptionPane.showMessageDialog(null, "Producto actualizado 😎");

        });
        JButton refresh = new JButton("Refresh 🔄");

        refresh.setBounds(890, 120, 170, 45);

        panel.add(refresh);
        refresh.addActionListener(e -> {

            ventana.dispose();

            main(new String[0]);

        });

        int y = 200;
        int x = 150;
        int contador = 0;

        for (Productos p : productos) {

            JButton btn = new JButton(p.getNombre() + " - $" + p.getPrecio());

            btn.setBounds(x, y, 300, 45);

            btn.addActionListener(e -> {
                carrito[0].agregar(p);
                area.setText(carrito[0].mostrar());
                total.setText("Total: $" + carrito[0].total());
            });

            panel.add(btn);

            y += 70;
            contador++;

            if (contador == 5) {
                contador = 0;
                y = 200;
                x += 350;
            }
        }
        JButton pagar = new JButton("Pagar 💳");
        pagar.setBounds(420, 850, 220, 45);
        pagar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Compra realizada con éxito 🛒");
            area.setText("");
            total.setText("Total: $0");
            Pago pago = new PagoTarjeta();
            Pedido pedido = new Pedido(carrito[0].mostrar(), carrito[0].total());
            JOptionPane.showMessageDialog(null,
                    pago.pagar(carrito[0].total()) + "\n\n" + pedido.mostrarPedido()
            );
            carrito[0] = new Carrito();
            area.setText("");

            total.setText("Total: $0");
        });
        panel.add(pagar);

        ventana.add(panel);
        ventana.setVisible(true);
    }
}
