/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service;
import com.mycompany.molde.Productos;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class ProductoService {

    public ArrayList<Productos> obtenerProductos() {
        ArrayList<Productos> lista = new ArrayList<>();

        lista.add(new Productos("Figura Naruto", 50));
        lista.add(new Productos("Manga One Piece", 20));
        lista.add(new Productos("Cosplay Nezuko", 80));
        lista.add(new Productos("Camiseta Anime", 35));
        lista.add(new Productos("Llavero Dragon Ball", 10));

        return lista;
    }
}