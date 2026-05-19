package PaqueteVO;

public class Grupo_viaje {
    private int id_grupo;
    private int id_viaje;

    public Grupo_viaje(int id_grupo, int id_viaje) {
        this.id_grupo = id_grupo;
        this.id_viaje = id_viaje;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    @Override
    public String toString() {
        return "Grupo_viaje [id_grupo=" + id_grupo + ", id_viaje=" + id_viaje + "]";
    }
    
}
