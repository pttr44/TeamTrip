package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.PrecioDAO;
import PaqueteVO.Precio;
import java.sql.Connection;

public class PrecioControl {

    public void anadirPrecio(double valor) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            PrecioDAO.Precioviaje(conn, -1, valor);
        }
    }

    public boolean actualizarPrecio(int idPrecio, double valor) throws Exception {
        try (Connection conn = Conexion.getConnection()) {
            return PrecioDAO.nuvoPrecioviaje(conn, new Precio(idPrecio, valor));
        }
    }
}

