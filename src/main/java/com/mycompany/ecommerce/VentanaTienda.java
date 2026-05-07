
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
      
       
        final Carrito[] carrito = { new Carrito() };

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
                carrito[0].agregar(p);
                area.setText(carrito[0].mostrar());
                total.setText("Total: $" + carrito[0].total());
            });

            panel.add(btn);
            y += 40;
        }

        JButton pagar = new JButton("Pagar 💳");
        pagar.setBounds(120, 420, 150, 30);

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