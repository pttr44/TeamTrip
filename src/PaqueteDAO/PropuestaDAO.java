package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PropuestaDAO {
    
    public void insertarPropuesta(Propuesta propuesta, Connection conexion) {
        
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

    public void eliminarPropuesta(int id_Propuesta, Connection conexion) {
        String consulta = "DELETE FROM propuesta WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_Propuesta);
            
            ps.executeUpdate();
            System.out.println("Propuesta eliminada correctamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar la propuesta: " + e.getMessage());
        }
    }

    public void modificarPropuesta(Propuesta propuesta, Connection conexion) {
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

    public void mostrarPropuesta(int id_Propuesta, Connection conexion) {
        String consulta = "SELECT * FROM propuesta WHERE id_Propuesta = ?";
    
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_Propuesta);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_Propuesta"));
                    System.out.println("Propuesta: " + rs.getString("propuesta"));
                } else {
                    System.out.println("No se encontró ninguna propuesta con el ID: " + id_Propuesta);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar la propuesta: " + e.getMessage());
        }
    }
}