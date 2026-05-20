package PaqueteDAO;

import PaqueteVO.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupoDAO {

    public static int crearGrupo(Connection conn, String nombre) throws SQLException {
        String sql = "INSERT INTO grupo (nombre) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public static Grupo obtenerGrupo(Connection conn, int id_grupo) throws SQLException {
        String sql = "SELECT id_grupo, nombre FROM grupo WHERE id_grupo = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_grupo);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }
                return new Grupo(rs.getInt("id_grupo"), rs.getString("nombre"));
            }
        }
    }

    public static List<Grupo> listarGrupos(Connection conn) throws SQLException {
        String sql = "SELECT id_grupo, nombre FROM grupo ORDER BY id_grupo DESC";
        List<Grupo> grupos = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                grupos.add(new Grupo(rs.getInt("id_grupo"), rs.getString("nombre")));
            }
        }
        return grupos;
    }

    public static void anadirUsuarioAlGrupo(Connection conn, int id_grupo, String dni) throws SQLException {
        String sql = "INSERT INTO usuario_grupo (id_grupo, dni) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_grupo);
            ps.setString(2, dni);
            ps.executeUpdate();
        }
    }
}
