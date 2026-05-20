package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.LugarDAO;
import PaqueteDAO.ViajeDAO;
import PaqueteVO.Viaje;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class ViajeControl {

    public int crearViaje(LocalDate inicio, LocalDate fin, String idLugar) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            // Si el lugar no existe, el INSERT fallará; damos la opción de crearlo antes.
            try {
                LugarDAO.anadirLugar(conn, idLugar);
            } catch (Exception ignored) {
                // Ignorar si ya existe o si la tabla tiene otra restricción.
            }
            return ViajeDAO.anadirViaje(conn, inicio, fin, idLugar);
        }
    }

    public void modificarViaje(int idViaje, LocalDate inicio, LocalDate fin, String idLugar) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            ViajeDAO.modificarViaje(conn, idViaje, inicio, fin, idLugar);
        }
    }

    public void eliminarViaje(int idViaje) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            ViajeDAO.eliminarViaje(conn, idViaje);
        }
    }

    public Viaje obtenerViaje(int idViaje) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return ViajeDAO.obtenerViaje(conn, idViaje);
        }
    }

    public List<Viaje> listarViajes() throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return ViajeDAO.listarViajes(conn);
        }
    }
}

