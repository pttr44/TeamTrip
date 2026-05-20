package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PropuestaDAO {
    
    public static void insertarPropuesta(String propuesta, Connection conexion, String estado, String dni, int id_Propuesta) {
        
        String consulta = "INSERT INTO propuesta (id_Propuesta, propuesta, dni, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_Propuesta);
            ps.setString(2, propuesta);
            ps.setString(3, dni);
            ps.setString(4, estado);
            
            ps.executeUpdate();
            System.out.println("Propuesta insertada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al insertar la propuesta: " + e.getMessage());
        }
    }

    public static void eliminarPropuesta(int id_Propuesta, Connection conexion) {
        String consulta = "DELETE FROM propuesta WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_Propuesta);
            
            ps.executeUpdate();
            System.out.println("Propuesta eliminada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar la propuesta: " + e.getMessage());
        }
    }

    public static void modificarPropuesta(String propuesta, Connection conexion, int id_Propuesta) {
        String consulta = "UPDATE propuesta SET propuesta = ? WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, propuesta);
            ps.setInt(2, id_Propuesta);
            
            ps.executeUpdate();
            System.out.println("Propuesta modificada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al modificar la propuesta: " + e.getMessage());
        }
    }

    public static Propuesta mostrarPropuesta(int id_Propuesta, Connection conexion) {
        String consulta = "SELECT * FROM propuesta WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_Propuesta);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id_Propuesta");
                    String propuesta = rs.getString("propuesta");
                    String dni = rs.getString("dni");
                    String estado = rs.getString("estado");
                    
                    return new Propuesta(id, propuesta, dni, estado);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar la propuesta: " + e.getMessage());
        }
        return null;
    }

    public static int idUltimaPropuesta(Connection conexion) {
        String consulta = "SELECT MAX(id_Propuesta) AS max_id FROM propuesta";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {
            
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                return maxId + 1;
            }
            
        } catch (Exception e) {
            System.out.println("Error al obtener el ID de la última propuesta: " + e.getMessage());
        }
        return -1;
    }
}