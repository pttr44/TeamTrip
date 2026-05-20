package PaqueteDAO;

import PaqueteVO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usuario_grupoDAO {
    public static List<String> nombresPorIdGrupo(int id_grupo, Connection conn) {
        List<String> lista = new ArrayList<>();
        String sql = "select nombre_completo FROM usuario where dni in (select dni from usuario_grupo where id_grupo = (?))";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

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

    public static void añadirUsuarioGrupo(int id_grupo, String dni, Connection conn){
        String sql = "insert into usuario_grupo values (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_grupo);
                ps.setString(2, dni);
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarUsuarioGrupo(int id_grupo, Usuario usuario, Connection conn){
        String sql = "delete from usuario_grupo where id_grupo = (?) and dni = (?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_grupo);
                ps.setString(2, usuario.getDni());
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
