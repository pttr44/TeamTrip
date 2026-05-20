package PaqueteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LugarDAO {

    public static void anadirLugar(Connection conexion, String id_lugar) throws SQLException {
        if (id_lugar == null || id_lugar.trim().isEmpty()) {
            throw new IllegalArgumentException("El lugar está vacío.");
        }
        String consulta = "INSERT INTO lugar (id_lugar) VALUES (?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, id_lugar.trim());
            ps.executeUpdate();
        }
    }

    public static List<String> listarLugares(Connection conexion) throws SQLException {
        String consulta = "SELECT id_lugar FROM lugar ORDER BY id_lugar";
        List<String> lugares = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lugares.add(rs.getString("id_lugar"));
            }
        }
        return lugares;
    }
}

