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
public class Pedido {
    private String detalle;
    private double total;

    public Pedido(String detalle, double total) {
        this.detalle = detalle;
        this.total = total;
    }

    public String mostrarPedido() {
        return "Pedido:\n" + detalle + "\nTotal: $" + total;
    }
}