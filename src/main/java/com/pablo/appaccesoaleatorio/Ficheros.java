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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {

    public static void main(String[] args) {

        try {
            File directorio = new File("I:\\AD");
//            File raiz = new File("C:\\");
//            File[] ficheros = raiz.listFiles();
//            int directorios = 0;
//            int numFich = 0;
//            for (File fichero : ficheros) {
//                if (fichero.isDirectory()) {
//                    directorios++;
//                } else {
//                    numFich++;
            File fichero = new File(directorio, "ejercicio1.dat");
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
//                    fichero.delete();
            fichero.createNewFile();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
//        System.out.println("Directorios: " + directorios
//                + " Ficheros: " + numFich);
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        }
