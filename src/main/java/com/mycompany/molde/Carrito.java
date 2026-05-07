/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.molde;
import java.util.ArrayList;
/**
 *
 * @author DELL
 */
public class Carrito {
    private ArrayList<Productos> lista = new ArrayList<>();

    public void agregar(Productos p) {
        lista.add(p);
        System.out.println("Agregado: " + p.getNombre());
    }

    public double total() {
        double t = 0;
        for (Productos p : lista) {
            t += p.getPrecio();
        }
        return t;
    }

    public String mostrar() {
        String s = "";
        for (Productos p : lista) {
            s += p.toString() + "\n";
        }
        return s;
    }
}
