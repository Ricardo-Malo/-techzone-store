/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.molde;

/**
 *
 * @author DELL
 */
public class PagoTarjeta extends Pago {

    @Override
    public String pagar(double monto) {
        return " Pago con tarjeta exitoso: $" + monto;
    }
}
