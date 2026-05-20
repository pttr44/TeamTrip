package PaqueteDAO;

import PaqueteVO.Usuario_grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Usuario_grupoDAO {

    public static void insertar(Connection conn, Usuario_grupo ug) throws SQLException {
        String sql = "INSERT INTO usuario_grupo (id_grupo, dni) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ug.getId_grupo());
            ps.setString(2, ug.getDni());
            ps.executeUpdate();
        }
    }

    public static void eliminar(Connection conn, int id_grupo, String dni) throws SQLException {
        String sql = "DELETE FROM usuario_grupo WHERE id_grupo = ? AND dni = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_grupo);
            ps.setString(2, dni);
            ps.executeUpdate();
        }
    }

    public static List<Usuario_grupo> listarPorGrupo(Connection conn, int id_grupo) throws SQLException {
        String sql = "SELECT id_grupo, dni FROM usuario_grupo WHERE id_grupo = ? ORDER BY dni";
        List<Usuario_grupo> lista = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_grupo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Usuario_grupo(rs.getInt("id_grupo"), rs.getString("dni")));
                }
            }
        }
        return lista;
    }
}

