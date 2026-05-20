package PaqueteDAO;

import PaqueteCONEX.Conexion;
import PaqueteVO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class GrupoDAO {
    public static List<String> listVisibles(int id_grupo) {
        List<String> lista = new ArrayList<>();
        String sql = "select nombre FROM grupo where id_grupo = ?";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id_grupo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(rs.getString("nombre"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void añadirUsuario(int id_grupo, Usuario usuario){
        String sql = "insert into grupo values (?, ?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    ps.setInt(1, id_grupo);
                    ps.setString(2, usuario.getNombre_completo());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}