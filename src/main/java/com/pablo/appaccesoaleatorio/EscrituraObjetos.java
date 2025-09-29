/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Diurno
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraObjetos {

    public static void main(String[] args) {
        Entrada e = new Entrada(0, "Quijote",
                new Random().nextDouble(10, 20));
        File f = new File("I:\\AD\\entradas.dat");
        if (!f.exists()) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(f));
//                f.createNewFile();
                oos.writeObject(e);
                oos.close();
            } catch (IOException ex) {
                System.err.println("Error al crear el fichero");
            }
        } else {
            try {
                FileOutputStream fos = new FileOutputStream(f, true);
                MiObjectOutputStream oos = new MiObjectOutputStream(fos);
                oos.writeObject(e);
                oos.close();
            } catch (FileNotFoundException ex) {
                System.err.println("Error al cargar el fichero");
            } catch (IOException ex) {
                System.err.println("Error al guardar el objeto");
            }
        }
    }
}

