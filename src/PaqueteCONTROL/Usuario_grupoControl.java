package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.Usuario_grupoDAO;
import java.util.Scanner;

public class Usuario_grupoControl {
    Conexion conn = new Conexion();
    Scanner miEntrada = new Scanner(System.in);

    public void validarNombresPorIdGrupo(){
        System.out.println("Introduzca el id del grupo del que quiere ver los nombres de cada usuario");
        int id_grupo = miEntrada.nextInt();
        try {
            System.out.println(Usuario_grupoDAO.nombresPorIdGrupo(id_grupo, conn.getConexion()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarAñadirUsuarioGrupo(){
        System.out.println("Introduzca el dni del usuario que quiere añadir al grupo con id ");
    }
}