package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String URL = "jdbc:sqlite:tienda.db";

    public static Connection conectar() {

        try {
            Connection conexion = DriverManager.getConnection(URL);
            System.out.println("Conexion exitosa a SQLite");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e.getMessage());

            return null;
            
        }
    }
    public static void crearTabla() {

    String sql = "CREATE TABLE IF NOT EXISTS productos ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nombre TEXT NOT NULL,"
            + "precio REAL NOT NULL"
            + ");";

    try (Connection conexion = conectar();
         Statement stmt = conexion.createStatement()) {

        stmt.execute(sql);

        System.out.println("Tabla productos creada");

    } catch (SQLException e) {

        System.out.println("Error creando tabla: " + e.getMessage());
    }
}   
}