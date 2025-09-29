/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Pablo
 */
import java.io.Serializable;

public class Entrada  implements Serializable {

    private int codigo;
    private String titulo;
    private double precio;

    public Entrada(int codigo, String titulo, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Entrada{" + "codigo=" + codigo + ", titulo=" + titulo + ", precio=" + precio + '}';
    }

}
