package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.GrupoDAO;
import PaqueteDAO.Usuario_grupoDAO;
import PaqueteVO.Grupo;
import PaqueteVO.Usuario_grupo;
import java.sql.Connection;
import java.util.List;

public class GrupoControl {

    public int crearGrupo(String nombre, String dniCreador) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            int idGrupo = GrupoDAO.crearGrupo(conn, nombre);
            if (idGrupo > 0 && dniCreador != null && !dniCreador.isBlank()) {
                Usuario_grupoDAO.insertar(conn, new Usuario_grupo(idGrupo, dniCreador));
            }
            return idGrupo;
        }
    }

    public void invitarUsuario(int idGrupo, String dni) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            GrupoDAO.anadirUsuarioAlGrupo(conn, idGrupo, dni);
        }
    }

    public List<Usuario_grupo> miembros(int idGrupo) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return Usuario_grupoDAO.listarPorGrupo(conn, idGrupo);
        }
    }

    public List<Grupo> listarGrupos() throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return GrupoDAO.listarGrupos(conn);
        }
    }
}

