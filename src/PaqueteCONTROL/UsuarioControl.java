package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.UsuarioDAO;
import PaqueteVO.Usuario;
import java.sql.Connection;

public class UsuarioControl {

    public Usuario iniciarSesion(String dni, String nombreCompleto) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            Usuario usuario = UsuarioDAO.mostrarUsuario(dni, conn);
            if (usuario == null) {
                return null;
            }
            if (nombreCompleto == null || nombreCompleto.isBlank()) {
                return null;
            }
            return usuario.getNombre_completo().equalsIgnoreCase(nombreCompleto.trim()) ? usuario : null;
        }
    }

    public Usuario registrarse(String dni, String nombreCompleto) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            Usuario existente = UsuarioDAO.mostrarUsuario(dni, conn);
            if (existente != null) {
                return existente;
            }
            Usuario usuario = new Usuario(dni, nombreCompleto, "normal");
            UsuarioDAO.insertarUsuario(usuario, conn);
            return usuario;
        }
    }
}

