package PaqueteDAO;

import PaqueteVO.Precio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrecioDAO {

    public void Precioviaje(Connection conexion, int id_precio, double valor) throws SQLException {
        if (valor == -1.0 || Double.isNaN(valor)) {
            throw new IllegalArgumentException("El precio está vacío.");
        }

        String conId = "INSERT INTO precio (id_precio, valor) VALUES (?, ?)";
        String sinId = "INSERT INTO precio (valor) VALUES (?)";

        if (id_precio > 0) {
            try (PreparedStatement ps = conexion.prepareStatement(conId)) {
                ps.setInt(1, id_precio);
                ps.setDouble(2, valor);
                ps.executeUpdate();
            }
        } else {
            try (PreparedStatement ps = conexion.prepareStatement(sinId)) {
                ps.setDouble(1, valor);
                ps.executeUpdate();
            }
        }
    }

    public boolean nuvoPrecioviaje(Connection conexion, Precio precio) throws SQLException {
        String actualizar = "UPDATE precio SET valor = ? WHERE id_precio = ?";

        try (PreparedStatement ps = conexion.prepareStatement(actualizar)) {
            ps.setDouble(1, precio.getValor());
            ps.setInt(2, precio.getId_precio());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
