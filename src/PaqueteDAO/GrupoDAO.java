package PaqueteDAO;

import PaqueteCONEX.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class GrupoDAO {
    public static void crearGrupo(String nombre){
        String sql = "insert into grupo (nombre) values (?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void eliminarGrupo(int id_grupo){
        String sql = "delete from grupo where id_grupo = (?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_grupo);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cambiarNombreGrupo(String nombre, int id_grupo){
        String sql = "update grupo set nombre = (?) where id_grupo = (?)";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, id_grupo);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
