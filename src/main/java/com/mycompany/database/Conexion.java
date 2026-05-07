package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String URL = "jdbc:sqlite:tienda.db";

    public static Connection conectar() {

        try {
            
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexion exitosa a SQLite");

            return conexion;

        } catch (Exception e) {

            System.out.println("Error de conexion: " + e.getMessage());

            return null;
            
        }
    }
    public static void crearTabla() {
        
    Conexion.insertarProducto("Figura Naruto", 50);
    Conexion.insertarProducto("Manga One Piece", 20);
    Conexion.insertarProducto("Cosplay Nezuko", 80);
    Conexion.insertarProducto("Camiseta Anime", 35);
    Conexion.insertarProducto("Llavero Dragon Ball", 10);

   String sql = "CREATE TABLE IF NOT EXISTS productos ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "nombre TEXT UNIQUE NOT NULL,"
        + "precio REAL NOT NULL"
        + ");";

    try (Connection conexion = conectar();
         Statement stmt = conexion.createStatement()) {

        stmt.execute(sql);

        System.out.println("Tabla productos creada");

    } catch (SQLException e) {

        System.out.println("Error creando tabla: " + e.getMessage());
    }
}   public static void insertarProducto(String nombre, double precio) {

    String sql = "INSERT OR IGNORE INTO productos(nombre, precio) VALUES(?, ?)";
    
    try (
        Connection conexion = conectar();
        java.sql.PreparedStatement pstmt = conexion.prepareStatement(sql)
    ) {

        pstmt.setString(1, nombre);
        pstmt.setDouble(2, precio);

        pstmt.executeUpdate();

        System.out.println("Producto guardado");

    } catch (Exception e) {

        System.out.println("Error insertando producto: " + e.getMessage());

    }
}
}