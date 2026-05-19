package PaqueteVO;

public class Propuesta {
    
    private int id_Propuesta;
    private String propuesta;

    public Propuesta(int id_Propuesta, String propuesta) {
        this.id_Propuesta = id_Propuesta;
        this.propuesta = propuesta;
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

    @Override
    public String toString() {
        return "Propuesta [id_Propuesta=" + id_Propuesta + ", propuesta=" + propuesta + "]";
    }
}
