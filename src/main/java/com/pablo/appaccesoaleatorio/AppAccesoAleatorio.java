package com.pablo.appaccesoaleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.management.StringValueExp;

/**
 *
 * @author Diurno
 */
public class AppAccesoAleatorio {

    private static RandomAccessFile fichAleatorio;

    public static void main(String[] args) {
        AppAccesoAleatorio a = new AppAccesoAleatorio();
        System.out.println("++++GESTOR DE EMPLEADOS++++");
        try {
            fichAleatorio = new RandomAccessFile("fichero.dat", "rw");
            a.menu();
            fichAleatorio.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(AppAccesoAleatorio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(AppAccesoAleatorio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (Exception ex) {
            System.getLogger(AppAccesoAleatorio.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private boolean existe(int id) throws IOException {
        fichAleatorio.seek(0);
        while (fichAleatorio.getFilePointer() < fichAleatorio.length()) {
            if (id == fichAleatorio.readInt()) {
                return true;
            } else {
                fichAleatorio.skipBytes(40 + 4 + 8);
            }
        }
        return false;
    }

    private void consulta(int id) throws IOException {
        if (!existe(id)) {
            System.out.println("----El empleado no existe----");
            menu();
        }
        fichAleatorio.seek(0);
        while (fichAleatorio.getFilePointer() < fichAleatorio.length()) {
            if (id == fichAleatorio.readInt()) {
                System.out.println("ID empleado: " + id);
                System.out.print("Nombre: ");
                for (int i = 0; i < 20; i++) {
                    System.out.print(fichAleatorio.readChar());
                }
                System.out.println("");
                System.out.println("Departamento: " + fichAleatorio.readInt());
                System.out.println("Salario: " + fichAleatorio.readDouble());
            } else {
                fichAleatorio.skipBytes(40 + 4 + 8);
            }
        }
    }

    private void escribirEmpleado(int id, String apellido, int depart, double salario) throws IOException {
        if (existe(id)) {
            System.out.println("----El id del empleado ya existe----");
            menu();
        }
        fichAleatorio.seek(fichAleatorio.length());
        fichAleatorio.writeInt(id);
        StringBuffer buffer = new StringBuffer(apellido);
        buffer.setLength(20);
        fichAleatorio.writeChars(buffer.toString());
        fichAleatorio.writeInt(depart);
        fichAleatorio.writeDouble(salario);
    }

    private void modificarEmpleadoSalario(int id, double salario) throws IOException {
        if (!existe(id)) {
            System.out.println("----El empleado no existe----");
            menu();
        }
        fichAleatorio.seek(0);
        while (fichAleatorio.getFilePointer() < fichAleatorio.length()) {
            if (id == fichAleatorio.readInt()) {
                System.out.print("Apellido: ");
                for (int i = 0; i < 20; i++) {
                    System.out.print(fichAleatorio.readChar());
                }
                System.out.println("");
                fichAleatorio.skipBytes(4);
                double salarioAntiguo = fichAleatorio.readDouble();
                System.out.println("Salario Antiguo: " + salarioAntiguo);
                double salarioNuevo = salario + salarioAntiguo;
                int posicionActual = (int) fichAleatorio.getFilePointer();
                fichAleatorio.seek(posicionActual - 8);
                fichAleatorio.writeDouble(salarioNuevo);
            } else {
                fichAleatorio.skipBytes(40 + 4 + 8);
            }
        }
    }

    private void borrarEmpleado(int id) throws IOException {
        if (!existe(id)) {
            System.out.println("----El empleado no existe----");
            menu();
        }
        fichAleatorio.seek(0);
        while (fichAleatorio.getFilePointer() < fichAleatorio.length()) {
            if (id == fichAleatorio.readInt()) {
                int puntero = (int) fichAleatorio.getFilePointer();
                fichAleatorio.seek(puntero - 4);
                fichAleatorio.writeInt(-1);
                StringBuffer nombre = new StringBuffer(String.valueOf(id));
                nombre.setLength(20);
                fichAleatorio.writeChars(nombre.toString());
                fichAleatorio.writeInt(0);
                fichAleatorio.writeDouble(0);
            } else {
                fichAleatorio.skipBytes(40 + 4 + 8);
            }
        }
    }

    private void menu() throws IOException {
        Scanner sc = new Scanner(System.in);
        String entrada = null;
        do {
            System.out.println("1.-Consultar Empleado");
            System.out.println("2.-Insertar Empleado");
            System.out.println("3.-Modificar Empleado");
            System.out.println("4.-Borrar Empleado");
            System.out.println("0.- Salir");
            sc = new Scanner(System.in);
            entrada = sc.nextLine();
            switch (entrada) {
                case "1": {
                    System.out.println("Introduce el ID: ");
                    sc = new Scanner(System.in);
                    consulta(sc.nextInt());
                    break;
                }
                case "2": {
                    System.out.println("Introduce el ID: ");
                    sc = new Scanner(System.in);
                    int id = sc.nextInt();
                    System.out.println("Introduce el apellido: ");
                    sc = new Scanner(System.in);
                    String apellido = sc.nextLine();
                    System.out.println("Introduce el departamento: ");
                    sc = new Scanner(System.in);
                    int depart = sc.nextInt();
                    System.out.println("Introduce el salario: ");
                    sc = new Scanner(System.in);
                    double salario = sc.nextDouble();
                    escribirEmpleado(id, apellido, depart, salario);
                    break;
                }
                case "3": {
                    System.out.println("Introduce el ID: ");
                    int id = sc.nextInt();
                    System.out.println("Introduce el salario a añadir: ");
                    double salario = sc.nextDouble();
                    modificarEmpleadoSalario(id, salario);
                    break;
                }
                case "4": {
                    System.out.println("Introduce el ID: ");
                    borrarEmpleado(sc.nextInt());
                    break;
                }
            }
        } while (!entrada.equals("0"));
    }
}
