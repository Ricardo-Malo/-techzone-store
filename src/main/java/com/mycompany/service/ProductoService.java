/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;
import com.mycompany.database.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mycompany.molde.Productos;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ProductoService {

    public ArrayList<Productos> obtenerProductos() {

    ArrayList<Productos> lista = new ArrayList<>();

    String sql = "SELECT * FROM productos";

    try (
        Connection conexion = Conexion.conectar();
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {

        while (rs.next()) {

            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");

            lista.add(new Productos(nombre, precio));
        }

    } catch (SQLException e) {

        System.out.println("Error obteniendo productos: " + e.getMessage());
    }

    return lista;
}
}