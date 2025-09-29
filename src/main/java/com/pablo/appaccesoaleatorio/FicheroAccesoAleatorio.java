/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Diurno
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class FicheroAccesoAleatorio {

    static RandomAccessFile f;

    public static void main(String[] args) {
        f = null;
        try {
            f = new RandomAccessFile("ficheroAleatorio.dat",
                    "r");
            f.seek(56);
            System.out.println(f.readInt());
            for (int i = 0; i < 20; i++) {
                System.out.print(f.readChar());
            }
            
            System.out.println("\n" + f.readInt());
            System.out.println(f.readDouble());
            System.out.println(f.length());
        } catch (FileNotFoundException ex) {
            System.err.println("No existe el fichero");
        } catch (IOException ex) {
            System.err.println("No se puede editar el fichero");
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero");
            }
        }
    }

    public void escribirEmpleado() throws IOException {
        f.writeInt(1);
        String nombre = "Pepe García";
        StringBuffer buffer = new StringBuffer(nombre);
        buffer.setLength(20);
        f.writeChars(buffer.toString());
        f.writeInt(1);
        f.writeDouble(2100.54);

        f.writeInt(2);
        nombre = "Pepa Pérez";
        buffer = new StringBuffer(nombre);
        buffer.setLength(20);
        f.writeChars(buffer.toString());
        f.writeInt(2);
        f.writeDouble(2400.54);
    }
}

