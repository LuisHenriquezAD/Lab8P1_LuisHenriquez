package lab8p1_luishenriquez;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class LAB8P1_LuisHenriquez {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        boolean continuar = true;
        while (continuar) {
            System.out.println("TENGO VARIOS SCANNERS Y HABLE CON STEPHANIE YA QUE TENIA UN ERROR AL MOMENTO DE INGRESAR DATOS ");
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

                    cambiar(librero);
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
        Scanner leer = new Scanner(System.in);
        Scanner Lea = new Scanner(System.in);
        Scanner LEER = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de filas para el librero: ");
        int filas = leer.nextInt();
        System.out.print("Ingrese la cantidad de columnas para el librero: ");
        int columnas = leer.nextInt();

        Libro[][] librero = new Libro[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el titulo del libro");
                String titulo = Lea.nextLine();
                System.out.println("Ingrese el escritor: ");
                String escritor = LEER.nextLine();
                System.out.println("Ingrese el ano de publicacion del libro");
                int publicacion = leer.nextInt();
                Libro libro = new Libro(titulo, escritor, publicacion);

                librero[i][j] = libro;

                System.out.println("El libro fue agregado exitosamente");
            }
        }

        return librero;
    }

    public static void imprimir(Libro[][] librero) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                System.out.print(" [ " + librero[i][j].titulo() + " ] ");
            }
            System.out.println();
        }
    }
    
     public static void imprimircambiado(Libro[][] librero, String retitulo) {
        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                System.out.print(" [ " + librero[i][j].retitulo(retitulo) + " ] ");
            }
            System.out.println();
        }
    }

    public static void cambiar(Libro[][] librero) {
        int fila = -1;
        int colum = -1;

        Scanner leer = new Scanner(System.in);
        Scanner Lea = new Scanner(System.in);
        Scanner LEER = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titulo de libro que desea buscar ");
        String tit = scanner.nextLine();

        for (int i = 0; i < librero.length; i++) {
            for (int j = 0; j < librero[i].length; j++) {
                if (librero[i][j].titulo().equals(tit)) {
                    fila = i;
                    colum = j;
                    break;
                }
            }
            if (fila != -1 && colum != -1) {
                break;
            }

        }
        if (fila != -1 && colum != -1) {

            System.out.print("Ingrese el nuevo título del libro: ");
            String titulo = leer.nextLine();

            System.out.print("Ingrese el nuevo escritor: ");
            String escritor = Lea.nextLine();

            System.out.print("Ingrese el nuevo año de publicación: ");
            int publicacion = LEER.nextInt();

            librero[fila][colum].retitulo(titulo);

            librero[fila][colum].reescritor(escritor);

            librero[fila][colum].republicacion(publicacion);

            System.out.println("El libro fue modificado exitosamente");

            for (int i = 0; i < fila; i++) {
                for (int j = 0; j < colum; j++) {
                    Libro libro = new Libro(titulo, escritor, publicacion);

                    librero[i][j] = libro;
                }
            }
            imprimircambiado(librero,titulo);
            
            
        } else {
            System.out.println("El libro no fue encontrado en el librero.");
        }
    }
}
