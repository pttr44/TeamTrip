package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public static void insertarUsuario(Usuario usuario, Connection conexion) {

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

    public static void eliminarUsuario(String dni, Connection conexion) {
        String consulta = "DELETE FROM usuario WHERE dni = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, dni);
            
            ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    public static void modificarUsuario(Usuario usuario, Connection conexion) {
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

    public Usuario mostrarUsuario(String dniUsuario, Connection conexion) {
        String consulta = "SELECT * FROM usuario WHERE dni = ?";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, dniUsuario);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String dni = rs.getString("dni");
                    String nombre_completo = rs.getString("nombre_completo");
                    String tipo_user = rs.getString("tipo_user");
                    return new Usuario(dni, nombre_completo, tipo_user);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar el usuario: " + e.getMessage());
        }
        return null; 
    }
}