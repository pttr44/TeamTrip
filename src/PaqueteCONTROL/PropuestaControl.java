package PaqueteCONTROL;

import PaqueteDAO.PropuestaDAO;
import java.sql.Connection;
import java.util.Scanner;

public class PropuestaControl {

    Connection conexion;
    Scanner scan = new Scanner(System.in);
    
    public static void nuevaPropuesta(String dni, Connection conexion, Scanner scan) {
        Connection conec = conexion;

        System.out.println("Dime cual es tu propuesta: ");
        String propuesta = scan.nextLine();

        try {
            PropuestaDAO.insertarPropuesta(propuesta, conec, "pendiente", dni, PropuestaDAO.idUltimaPropuesta(conec));
        } catch (Exception e) {
            System.out.println("Error al registrar la propuesta: " + e.getMessage());
        }
    }

    public static void eliminarPropuesta(int id_Propuesta, Connection conexion, Scanner scan) {
        Connection conec = conexion;

        System.out.println("Dime el id de la propuesta que quieres eliminar: ");
        id_Propuesta = scan.nextInt();

        try {
            PropuestaDAO.eliminarPropuesta(id_Propuesta, conec);
        } catch (Exception e) {
            System.out.println("Error al eliminar la propuesta: " + e.getMessage());
        }
    }
}
