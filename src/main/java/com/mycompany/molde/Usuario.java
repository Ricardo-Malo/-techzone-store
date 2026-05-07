/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.molde;

/**
 *
 * @author DELL
 */
public class Usuario {
    protected String nombre;
    protected String rol;
 
public Usuario(String nombre, String rol){
    this.nombre = nombre;
    this.rol = rol;

}   

public String getRol(){
 return rol;
}
}