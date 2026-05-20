package PaqueteCONTROL;

import PaqueteDAO.LugarDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LugarControl {

    // Método auxiliar para gestionar la conexión.
    // Recuerda cambiarlo por la lógica de conexión que use tu proyecto (ej. ConexionBD.getConexion()).
    private Connection obtenerConexion() throws SQLException {
        throw new UnsupportedOperationException("Debes configurar aquí tu método de conexión a la base de datos.");
    }

    // Registra un nuevo lugar en la base de datos.
    public boolean agregarLugar(String idLugar) {
        try (Connection conn = obtenerConexion()) {
            LugarDAO.anadirLugar(conn, idLugar);
            System.out.println("[LugarControl] Lugar '" + idLugar + "' añadido correctamente.");
            return true;
        } catch (IllegalArgumentException e) {
            System.err.println("[LugarControl Error] Validación fallida: " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("[LugarControl Error] Error al añadir lugar: " + e.getMessage());
            return false;
        }
    }

    //Recupera la lista completa de lugares registrados.
    public List<String> obtenerLugares() {
        try (Connection conn = obtenerConexion()) {
            return LugarDAO.listarLugares(conn);
        } catch (SQLException e) {
            System.err.println("[LugarControl Error] Error al listar lugares: " + e.getMessage());
            return new ArrayList<>(); // Devolvemos lista vacía para evitar NullPointerException en la vista
        }
    }
}