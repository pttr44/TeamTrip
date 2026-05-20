package PaqueteDAO;

import PaqueteVO.Viaje_evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Viaje_eventoDAO {
    private static HashMap<String, List<Viaje_evento>> MapViajEvento = new HashMap<>();

    public static List<Viaje_evento> ViajEvento(Connection conexion, int id_viaje, int id_evento) throws SQLException {
        String cacheKey = id_viaje + ":" + id_evento;
        List<Viaje_evento> encontrado = MapViajEvento.get(cacheKey);
        if (encontrado != null) {
            System.out.println("Álbumes obtenidos del HashMap para ArtistId=" + cacheKey);
            return new ArrayList<>(encontrado);
        }

        String consulta = "SELECT id_viaje, id_evento FROM ViajEvento WHERE id_viaje = ? AND id_evento = ?";
        List<Viaje_evento> viaeven = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, id_viaje);
            ps.setInt(2, id_evento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int viaje = rs.getInt("id_viaje");
                    int evento = rs.getInt("id_evento");
                    viaeven.add(new Viaje_evento(viaje, evento));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MapViajEvento.put(cacheKey, new ArrayList<>(viaeven));
        return viaeven;
    }
}

