package lab8p1_luishenriquez;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class LAB8P1_LuisHenriquez {

    static Scanner lea = new Scanner(System.in);
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {

            String opciones = "Seleccione una opción:\n"
                    + "1. Crear biblioteca \n"
                    + "2. SALIR";

            JOptionPane.showMessageDialog(null, opciones);

            String opc = JOptionPane.showInputDialog("Ingrese una opción");
            int OPC = Integer.parseInt(opc);

            switch (OPC) {
                case 1: {
                    
                    Libro[][] librero = llenar();
                    imprimir(librero);    
                }
                break;

                case 2: {
                    continuar = false;
                }
                break;

                default: {
                    if (OPC != 2) {
                        JOptionPane.showMessageDialog(null, "NUMERO INVALIDO");
                    }

                }
                break;
            }//fin switch
        }//fin while
    }

    public static Libro[][] llenar() {
        System.out.print("Ingrese la cantidad de filas para el librero: ");
        int filas = leer.nextInt();
        System.out.print("Ingrese la cantidad de columnas para el librero: ");
        int columnas = leer.nextInt();

        Libro[][] librero = new Libro[filas][columnas];
       
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el titulo del libro");
                String titulo = leer.nextLine();
                System.out.println("Ingrese el escritor: ");
                String escritor = lea.nextLine();
                System.out.println("Ingrese el ano de publicacion del libro");
                int publicacion = lea.nextInt();
                Libro libro = new Libro(titulo, escritor, publicacion);
                
                librero[i][j] = libro;
                
                System.out.println("El libro fue agregado exitosamente");
            }
        }      
    
    return librero;
    }
    
    public static void imprimir(Libro[][] librero){
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                 System.out.print(" [ "+librero[i][j].titulo()+" ] ");
            }
             System.out.println();
        }    
    }

}
