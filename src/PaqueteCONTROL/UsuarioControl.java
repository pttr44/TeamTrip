package PaqueteCONTROL;

import java.sql.Connection;
import java.util.Scanner;

import PaqueteDAO.UsuarioDAO;

public class UsuarioControl {
    
    Connection conexion;
    Scanner scan = new Scanner(System.in);

    public static void registrarUsuario(Connection conexion, String dni, String nombre_completo) {
        Connection conec = conexion;

        try {
            UsuarioDAO.insertarUsuario(dni, conec, nombre_completo, "usuario");
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }

    }

    public static void eliminarUsuario(String dni, Connection conexion) {
        Connection conec = conexion;

        try {
            UsuarioDAO.eliminarUsuario(dni, conec);
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public static void modificarUsuario(String dni, Connection conexion, String nuevoNombreCompleto) {
        Connection conec = conexion;

        try {
            UsuarioDAO.modificarUsuario(dni, conec, nuevoNombreCompleto);
        } catch (Exception e) {
            System.out.println("Error al modificar el usuario: " + e.getMessage());
        }
    }
}
