package PaqueteAPP;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        mostrarMenu(scan);

        System.out.print("Selecciona una opción: ");
        int opcion = scan.nextInt();

        scan.nextLine();

        if (opcion == 1) {
            iniciarSesion(scan);
        }else if (opcion == 2) {
            registrarse(scan);
        } else {
            System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
        }

        opcionesMenu();
        int eleccion = scan.nextInt();
        
        switch (eleccion) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
        
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
                break;
        }
        scan.close();
    }

    public static void mostrarMenu(Scanner scan) {
        System.out.println("-----------------------------------------------------");
        System.out.println("|                                                   |");
        System.out.println("|  Bienvenido a la aplicación de gestión de planes  |");
        System.out.println("|                                                   |");
        System.out.println("|                                                   |");
        System.out.println("|  1)Iniciar sesión                                 |");
        System.out.println("|  2)Registrarse                                    |");
        System.out.println("|                                                   |");
        System.out.println("-----------------------------------------------------\n");

    }

    public static void iniciarSesion(Scanner scan) {
        System.out.println("Inicia sesión para acceder a tus planes\n");

        System.out.print("Dime tu dni: ");
        String dni = scan.nextLine();

        System.out.print("Dime tu nombre completo: ");
        String nombre = scan.nextLine();

        System.out.println("\nBienvenido, " + nombre + "\n");
    }

    public static void registrarse(Scanner scan) {
        System.out.println("Regístrate para crear tu cuenta\n");

        System.out.print("Dime tu dni: ");
        String dni = scan.nextLine();

        System.out.print("Dime tu nombre completo: ");
        String nombre = scan.nextLine();

        System.out.println("\nCuenta creada correctamente, bienvenido " + nombre + "\n");
    }

    public static void opcionesMenu(){
        System.out.println("-----------------------------------------------------");
        System.out.println("|                                                   |");
        System.out.println("| 1)Crear plan                                      |");
        System.out.println("| 2)Modificar plan                                  |");
        System.out.println("| 3)Eliminar plan                                   |");
        System.out.println("| 4)Invitar amigos                                  |");
        System.out.println("| 5)Salir de planes                                 |");
        System.out.println("| 6)Añadir gastos                                   |");
        System.out.println("| 7)Salir de la app                                 |");
        System.out.println("|                                                   |");
        System.out.println("-----------------------------------------------------\n");
    }
}
