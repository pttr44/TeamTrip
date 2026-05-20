package PaqueteDAO;

import PaqueteVO.Viaje;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViajeDAO {

    public static int anadirViaje(Connection conn, LocalDate fecha_inicio, LocalDate fecha_final, String id_lugar)
            throws SQLException {
        String consulta = "INSERT INTO viaje (fecha_inicio, fecha_fin, id_lugar) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, Date.valueOf(fecha_inicio));
            ps.setDate(2, Date.valueOf(fecha_final));
            ps.setString(3, id_lugar);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public static void modificarViaje(Connection conn, int id_viaje, LocalDate fecha_inicio, LocalDate fecha_final, String id_lugar)
            throws SQLException {
        String consulta = "UPDATE viaje SET fecha_inicio = ?, fecha_fin = ?, id_lugar = ? WHERE id_viaje = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setDate(1, Date.valueOf(fecha_inicio));
            ps.setDate(2, Date.valueOf(fecha_final));
            ps.setString(3, id_lugar);
            ps.setInt(4, id_viaje);
            ps.executeUpdate();
        }
    }

    public static void eliminarViaje(Connection conn, int id_viaje) throws SQLException {
        String consulta = "DELETE FROM viaje WHERE id_viaje = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setInt(1, id_viaje);
            ps.executeUpdate();
        }
    }

    public static Viaje obtenerViaje(Connection conn, int id_viaje) throws SQLException {
        String consulta = "SELECT id_viaje, fecha_inicio, fecha_fin FROM viaje WHERE id_viaje = ?";
        try (PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setInt(1, id_viaje);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                return new Viaje(
                        rs.getInt("id_viaje"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate());
            }
        }
    }

    public static List<Viaje> listarViajes(Connection conn) throws SQLException {
        String consulta = "SELECT id_viaje, fecha_inicio, fecha_fin FROM viaje ORDER BY id_viaje DESC";
        List<Viaje> viajes = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                viajes.add(new Viaje(
                        rs.getInt("id_viaje"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        rs.getDate("fecha_fin").toLocalDate()));
            }
        }
        return viajes;
    }
}
