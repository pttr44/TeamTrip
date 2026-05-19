package PaqueteVO;

public class Usuario {
    
    private int dni;
    private String nombre_completo;
    private String tipo_user;

    public Usuario(int dni, String nombre_completo, String tipo_user){
        this.dni = dni;
        this.nombre_completo = nombre_completo;
        this.tipo_user = tipo_user;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }

    @Override
    public String toString() {
        return "Usuario [dni=" + dni + ", nombre_completo=" + nombre_completo + ", tipo_user=" + tipo_user + "]";
    }
}
