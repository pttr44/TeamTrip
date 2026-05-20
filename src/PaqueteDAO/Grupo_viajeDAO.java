package PaqueteDAO;

import PaqueteVO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Grupo_viajeDAO {
    public List<Grupo_viaje> obtenerGruposViaje(Connection conexion, int id_grupo, int id_viaje) {
        String consulta = "SELECT * FROM grupo_viaje WHERE id_grupo = ? and id_viaje = ?";
        
        List<Grupo_viaje> gruposViaje = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            
            ps.setInt(1, id_grupo);
            ps.setInt(2, id_viaje);
            
            try (ResultSet rs = ps.executeQuery()) {
                
                while (rs.next()) {
                    int idGrupo = rs.getInt("id_grupo");
                    int idViaje = rs.getInt("id_viaje");
                    
                    Grupo_viaje grupoViaje = new Grupo_viaje(idGrupo, idViaje);
                    gruposViaje.add(grupoViaje);
                }
                
                return gruposViaje;
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los grupos de viaje: " + e.getMessage());
        }
        return gruposViaje;
    }   
}