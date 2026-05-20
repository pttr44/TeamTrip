package PaqueteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class EventoDAO {
    public static void añadirEvento(Connection conn, LocalDateTime fecha_hora, String nombre) throws SQLException{
        String consulta = "INSERT INTO evento (fecha_hora) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setTimestamp(1, Timestamp.valueOf(fecha_hora));
            ps.executeUpdate();
        }
    }

    public static void modificarEvento(Connection conn, LocalDateTime fecha_hora, String nombre_evento, int id_evento) throws SQLException{
        String consulta = "UPDATE evento SET fecha_hora = ? WHERE nombre = ? and id_evento = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setTimestamp(1, Timestamp.valueOf(fecha_hora));
            ps.setString(2, nombre_evento);
            ps.setInt(3, id_evento);
            ps.executeUpdate();
        }
    }

    public static void eliminarEvento(Connection conn, int id_evento) throws SQLException{
        String consulta = "DELETE FROM evnto WHERE id_evento = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setInt(1, id_evento);
            ps.executeUpdate();
        }
    }

    public static void filtrarEvento(Connection conn, String nombre_evento) throws SQLException{
        String consulta = "SELECT * FROM evento WHERE nombre = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)){
            ps.setString(1, nombre_evento);
            ps.executeUpdate();
        }
    }
}