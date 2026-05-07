/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommerce;
<<<<<<< HEAD
import com.mycompany.database.Conexion;
=======
>>>>>>> 172f5809e67458cff122015eff66cd63d76fb935
import com.mycompany.molde.*;
import com.mycompany.service.ProductoService;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class VentanaTienda {

    public static void main(String[] args) {
<<<<<<< HEAD
        Conexion.conectar();
=======
>>>>>>> 172f5809e67458cff122015eff66cd63d76fb935

        ProductoService service = new ProductoService();
        ArrayList<Productos> productos = service.obtenerProductos();

        Carrito carrito = new Carrito();

        JFrame ventana = new JFrame("OtakuStore 🎌");
        ventana.setSize(400, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);

        JLabel titulo = new JLabel("OTAKU STORE 🎌");
        titulo.setBounds(110, 20, 200, 30);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);

        JTextArea area = new JTextArea();
        area.setBounds(50, 250, 300, 120);
        panel.add(area);

        JLabel total = new JLabel("Total: $0");
        total.setBounds(150, 380, 200, 30);
        total.setForeground(Color.WHITE);
        panel.add(total);

        int y = 70;

        for (Productos p : productos) {
            JButton btn = new JButton(p.getNombre() + " - $" + p.getPrecio());
            btn.setBounds(80, y, 220, 30);

            btn.addActionListener(e -> {
                carrito.agregar(p);
                area.setText(carrito.mostrar());
                total.setText("Total: $" + carrito.total());
            });

            panel.add(btn);
            y += 40;
        }

        JButton pagar = new JButton("Pagar 💳");
        pagar.setBounds(120, 420, 150, 30);

        pagar.addActionListener(e -> {
            Pago pago = new PagoTarjeta();
            Pedido pedido = new Pedido(carrito.mostrar(), carrito.total());

            JOptionPane.showMessageDialog(null,
                    pago.pagar(carrito.total()) + "\n\n" + pedido.mostrarPedido()
            );
        });

        panel.add(pagar);

        ventana.add(panel);
        ventana.setVisible(true);
    }
}