package PaqueteDAO;

import PaqueteCONEX.Conexion;
import PaqueteVO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public static List<String> nombresPorIdGrupo(int id_grupo) {
        List<String> lista = new ArrayList<>();
        String sql = "select nombre_completo FROM usuario where dni in (select dni from usuario_grupo where id_grupo = (?))";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id_grupo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(rs.getString("nombre_completo"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void añadirUsuarioGrupo(int id_grupo, Usuario usuario){
        String sql = "insert into usuario_grupo values (?, ?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_grupo);
                ps.setString(2, usuario.getDni());
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarUsuarioGrupo(int id_grupo, Usuario usuario){
        String sql = "delete from usuario_grupo where id_grupo = (?) and dni = (?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_grupo);
                ps.setString(2, usuario.getDni());
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

