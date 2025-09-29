/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.pablo.appaccesoaleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 *
 * @author Diurno
 */
public class AppAccesoAleatorio {

    public static void main(String[] args) {
        try {
            
            File f = new File("fichero.dat");
            RandomAccessFile fichAleatorio = new RandomAccessFile(f, "rw");
            System.out.println("Hello World!");
        } catch (FileNotFoundException ex) {
            System.getLogger(AppAccesoAleatorio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    private void consulta(int id){
        
    }
}
