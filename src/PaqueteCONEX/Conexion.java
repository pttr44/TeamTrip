package PaqueteCONEX;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Conexion(){
        //Vacio por que quiero suponer que va asi
    }

    public Connection getConnection() throws Exception{
        try {
            
            String url = "jdbc:mysql://localhost:3306/teamtrip";
            String user = "root";
            String pwd = "mysql";

            return DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {
            throw (e);
        }
    }

    // Alias para mantener compatibilidad con el resto del codigo
    public Connection getConexion() throws Exception {
        return getConnection();
    }
}
