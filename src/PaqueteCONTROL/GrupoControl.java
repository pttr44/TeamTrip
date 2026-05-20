package PaqueteCONTROL;

import PaqueteCONEX.Conexion;
import PaqueteDAO.GrupoDAO;
import java.util.Scanner;

public class GrupoControl {
    Conexion conn = new Conexion();
    Scanner miEntrada = new Scanner(System.in);

    public void validarCrearGrupo(){
        System.out.println("Introduzca el nombre del grupo: ");
        String nombre = miEntrada.nextLine();
        try {
            GrupoDAO.crearGrupo(nombre, conn.getConexion());
            System.out.println("Grupo creado con nombre: " + nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarEliminarGrupo(){
        System.out.println("Introduzca el id del grupo que quiere eliminar");
        int id_grupo = miEntrada.nextInt();
        try {
            GrupoDAO.eliminarGrupo(id_grupo, conn.getConexion());
            System.out.println("El grupo con id " + id_grupo + " ha sido eliminado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validarCambiarNombreGrupo(){
        System.out.println("Introduzca el nuevo nombre del grupo: ");
        String nombre = miEntrada.nextLine();
        System.out.println("Introduzca el id del grupo al que quieres poner el nombre " + nombre);
        int id_grupo = miEntrada.nextInt();
        try {
            GrupoDAO.cambiarNombreGrupo(nombre, id_grupo, conn.getConexion());
            System.out.println("El nuevo nombre del grupo con id " + id_grupo + " es: " + nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
