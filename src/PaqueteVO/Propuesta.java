package PaqueteVO;

public class Propuesta {
    
    private int id_Propuesta;
    private String propuesta;
    private String dni;
    private String estado;

    public Propuesta(int id_Propuesta, String propuesta, String dni, String estado) {
        this.id_Propuesta = id_Propuesta;
        this.propuesta = propuesta;
        this.dni = dni;
        this.estado = estado;
    }

    public int getId_Propuesta() {
        return id_Propuesta;
    }

    public void setId_Propuesta(int id_Propuesta) {
        this.id_Propuesta = id_Propuesta;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(String propuesta) {
        this.propuesta = propuesta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Propuesta [id_Propuesta=" + id_Propuesta + ", propuesta=" + propuesta + ", dni=" + dni + ", estado=" + estado + "]";
    }
}
