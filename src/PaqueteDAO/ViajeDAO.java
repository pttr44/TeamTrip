package PaqueteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ViajeDAO {
    
    public static void añadirViaje(Connection conn, LocalDateTime fecha_inicio, LocalDateTime fecha_final, int id_lugar) throws SQLException{
        String consulta = "INSERT INTO viaje (fecha_inicio, fecha_fin, id_lugar) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setTimestamp(1, Timestamp.valueOf(fecha_inicio));
            ps.setTimestamp(2, Timestamp.valueOf(fecha_final));
            ps.setInt(2, id_lugar);
            ps.executeUpdate();
        }
    }

    public static void modificarViaje(Connection conn, LocalDateTime fecha_inicio, LocalDateTime fecha_final, int id_evento) throws SQLException{
        String consulta = "UPDATE viaje SET fecha_inicio = ?, fecha_fin = ? where id_evento = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setTimestamp(1, Timestamp.valueOf(fecha_inicio));
            ps.setTimestamp(2, Timestamp.valueOf(fecha_final));
            ps.setInt(3, id_evento);
            ps.executeUpdate();
        }
    }

    public static void eliminarViaje(Connection conn, int id_viaje) throws SQLException{
        String consulta = "DELETE FROM viaje WHERE id_viaje = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setInt(1, id_viaje);
            ps.executeUpdate();
        }
    }
}
