package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.EventoDAO;
import PaqueteVO.Evento;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class EventoControl {

    public void crearEvento(LocalDateTime fechaHora, String nombre) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            EventoDAO.anadirEvento(conn, fechaHora, nombre);
        }
    }

    public void modificarEvento(int idEvento, LocalDateTime fechaHora, String nombre) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            EventoDAO.modificarEvento(conn, fechaHora, nombre, idEvento);
        }
    }

    public void eliminarEvento(int idEvento) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            EventoDAO.eliminarEvento(conn, idEvento);
        }
    }

    public List<Evento> buscarPorNombre(String nombre) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return EventoDAO.filtrarEvento(conn, nombre);
        }
    }
}

