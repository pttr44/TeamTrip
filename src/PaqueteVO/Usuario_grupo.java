package PaqueteVO;

public class Usuario_grupo {
    private int id_grupo;
    private String dni;
    
    public Usuario_grupo(int id_grupo, String dni) {
        this.id_grupo = id_grupo;
        this.dni = dni;
    }
    public int getId_grupo() {
        return id_grupo;
    }
    public String getDni() {
        return dni;
    }
    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public String toString() {
        return "Usuario_grupo [id_grupo=" + id_grupo + ", dni=" + dni + "]";
    }
}
