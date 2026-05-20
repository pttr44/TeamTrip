package PaqueteCONEX;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Conexion(){
        //Vacio por que quiero suponer que va asi
    }

    public static Connection getConnection() throws Exception{
        try {
            
            String url = envOrDefault("TEAMTRIP_DB_URL", "jdbc:mysql://localhost:3306/teamtrip");
            String user = envOrDefault("TEAMTRIP_DB_USER", "root");
            String pwd = envOrDefault("TEAMTRIP_DB_PWD", "mysql");

            return DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {
            throw (e);
        }
    }

    // Alias para mantener compatibilidad con el resto del codigo
    public Connection getConexion() throws Exception {
        return getConnection();
    }

    private static String envOrDefault(String key, String fallback) {
        String v = System.getenv(key);
        return (v == null || v.isBlank()) ? fallback : v;
    }
}
