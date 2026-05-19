package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public void insertarUsuario(Usuario usuario, Connection conexion) {

        String consulta = "INSERT INTO usuario (dni, nombre_completo, tipo_user) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombre_completo());
            ps.setString(3, usuario.getTipo_user());
            
            ps.executeUpdate();
            System.out.println("Usuario insertado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(String dni, Connection conexion) {
        String consulta = "DELETE FROM usuario WHERE dni = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, dni);
            
            ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public void modificarUsuario(Usuario usuario, Connection conexion) {
        String consulta = "UPDATE usuario SET nombre_completo = ? WHERE dni = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, usuario.getNombre_completo());
            ps.setString(2, usuario.getDni()); 
            
            ps.executeUpdate();
            System.out.println("Usuario modificado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al modificar el usuario: " + e.getMessage());
        }
    }

    public void mostrarUsuario(String dni, Connection conexion) {
        String consulta = "SELECT * FROM usuario WHERE dni = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, dni);
            
            // Ejecutamos la consulta y recorremos el ResultSet
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("DNI: " + rs.getString("dni"));
                    System.out.println("Nombre Completo: " + rs.getString("nombre_completo"));
                    System.out.println("Tipo de Usuario: " + rs.getString("tipo_user"));
                } else {
                    System.out.println("No se encontró ningún usuario con el DNI: " + dni);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar el usuario: " + e.getMessage());
        }
    }
}