package PaqueteDAO;

import PaqueteVO.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    public static void anadirEvento(Connection conn, LocalDateTime fecha_hora, String nombre) throws SQLException {
        String consulta = "INSERT INTO evento (fecha_hora, nombre) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setTimestamp(1, Timestamp.valueOf(fecha_hora));
            ps.setString(2, nombre);
            ps.executeUpdate();
        }
    }

    public static void modificarEvento(Connection conn, LocalDateTime fecha_hora, String nombre_evento, int id_evento)
            throws SQLException {
        String consulta = "UPDATE evento SET fecha_hora = ?, nombre = ? WHERE id_evento = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setTimestamp(1, Timestamp.valueOf(fecha_hora));
            ps.setString(2, nombre_evento);
            ps.setInt(3, id_evento);
            ps.executeUpdate();
        }
    }

    public static void eliminarEvento(Connection conn, int id_evento) throws SQLException {
        String consulta = "DELETE FROM evento WHERE id_evento = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setInt(1, id_evento);
            ps.executeUpdate();
        }
    }

    public static List<Evento> filtrarEvento(Connection conn, String nombre_evento) throws SQLException {
        String consulta = "SELECT id_evento, fecha_hora, nombre FROM evento WHERE nombre = ?";
        List<Evento> eventos = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setString(1, nombre_evento);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    eventos.add(new Evento(
                            rs.getTimestamp("fecha_hora").toLocalDateTime(),
                            rs.getInt("id_evento"),
                            rs.getString("nombre")));
                }
            }
        }
        return eventos;
    }
}

