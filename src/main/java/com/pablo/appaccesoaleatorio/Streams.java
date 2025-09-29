/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Diurno
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Streams {

    public static File directorio = new File("I:\\AD");
    public static File fichero;

    public static void main(String[] args) {
        fichero = new File(directorio, "ejercicio1.dat");

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fichero));
            Entrada e = null;
            while (true) {
                e = (Entrada) ois.readObject();
                System.out.println(e);
            }
//            ObjectOutputStream oos = new ObjectOutputStream(
//                new FileOutputStream(fichero, true));
//            oos.writeObject(new Entrada(1, "Quijote", 17.89));
//            oos.writeObject(new Entrada(2, "Otro", 17.89));
//            oos.writeObject(new Entrada(3, "prueba", 17.89));
//            DataInputStream dis = new DataInputStream(
//                    new FileInputStream(fichero));
//            System.out.println(dis.readInt());
//            System.out.println(dis.readUTF());
//            System.out.println(dis.readDouble());
//            dos.writeUTF(new String("El ingenioso Hidalgo Don Quijote de la Mancha....")
//                    .substring(0, 20));
//            dos.writeDouble(17.89);
//            DataOutputStream dos = new DataOutputStream(
//                    new FileOutputStream(fichero));
//            dos.writeInt(12);
//            dos.writeUTF(new String("El ingenioso Hidalgo Don Quijote de la Mancha....")
//                    .substring(0, 20));
//            dos.writeDouble(17.89);
        } catch (FileNotFoundException ex) {
            System.err.println("Fichero no encontrado");
        } catch (IOException ex) {
            System.err.println("Fallo al leer");
        } catch (ClassNotFoundException ex) {
            System.out.println("La clase no existe");
        }
    }

    public static void ficheroBytes() {

        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
//            fos = new FileOutputStream(fichero);
            fis = new FileInputStream(fichero);
//            for (int i = 0; i < 10; i++) {
            int aux = fis.read();
            while (aux != -1) {
                System.out.println(aux);
                aux = fis.read();
            }
//                fos.write(i);
//                System.out.println(fis.read());
//            }
        } catch (FileNotFoundException ex) {
            System.err.println("El fichero no existe");
        } catch (IOException ex) {
            System.err.println("No hemos podido escribir sobre el fichero");
        }

        try {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        } catch (IOException ex) {
            System.err.println("Error al cerrar el stream de datos");
        }
    }
}
