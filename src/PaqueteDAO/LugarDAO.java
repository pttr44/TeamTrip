package PaqueteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LugarDAO {
    public void LugarDestino(Connection conexion, String id_lugar) throws SQLException {
        String consulta = "INSERT INTO lugar (id_lugar) VALUES (?)";

        if (id_lugar == null || id_lugar.trim().isEmpty()) { // Valida que el lugar no sea nulo o esté vacío.
            throw new IllegalArgumentException("El lugar estar vacío."); // Lanza una excepción si el nombre es inválido.
        }
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, id_lugar);
            ps.executeUpdate();
        }

        System.out.println("Lugar añadido correctamente.");
    }
}
