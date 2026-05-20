package PaqueteDAO;

import PaqueteCONEX.Conexion;
import PaqueteVO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usuario_grupoDAO {
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
<<<<<<< HEAD
}
=======
}
>>>>>>> main
