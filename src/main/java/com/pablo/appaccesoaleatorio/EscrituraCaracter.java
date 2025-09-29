/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablo.appaccesoaleatorio;

/**
 *
 * @author Diurno
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscrituraCaracter {

    public static void main(String[] args) {
        FileWriter fw = null;
        FileReader fr = null;
        File f = new File("I:\\AD", "texto.txt");
        try {
            fw = new FileWriter(f);
            fw.write("Prueba");
        } catch (FileNotFoundException e) {
            System.err.println("ERROR con fichero");
        } catch (IOException ex) {
            System.err.println("Error fichero");
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(EscrituraCaracter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                System.err.println("ERROR con fichero");
            }
        }
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            for (String s = ""; s != null; s = br.readLine()) {
                System.out.println(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraCaracter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscrituraCaracter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
