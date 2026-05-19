package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PropuestaDAO {
    
    public static void insertarPropuesta(Propuesta propuesta, Connection conexion) {
        
        String consulta = "INSERT INTO propuesta (id_Propuesta, propuesta) VALUES (?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, propuesta.getId_Propuesta());
            ps.setString(2, propuesta.getPropuesta());
            
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

    public static void modificarPropuesta(Propuesta propuesta, Connection conexion) {
        String consulta = "UPDATE propuesta SET propuesta = ? WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setString(1, propuesta.getPropuesta());
            ps.setInt(2, propuesta.getId_Propuesta());
            
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
                    
                    return new Propuesta(id, propuesta);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar la propuesta: " + e.getMessage());
        }
        return null;
    }
}