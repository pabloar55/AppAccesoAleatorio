/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Diurno
 */
import static com.pablo.appaccesoaleatorio.Streams.directorio;
import static com.pablo.appaccesoaleatorio.Streams.fichero;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LeerFicheroObjetos {

    public static void main(String[] args) {
        fichero = new File("I:\\AD", "entradas.dat");

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            Entrada e = null;
            while (true) {
                e = (Entrada) ois.readObject();
                System.out.println(e);
            }
        } catch (Exception e) {
            System.err.println("Error al leer");
        }
    }

}
