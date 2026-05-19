package PaqueteVO;
public class Viaje_evento {
    private int id_viaje;
    private int id_evento;

    public Viaje_evento(int id_evento, int id_viaje) {
        this.id_evento = id_evento;
        this.id_viaje = id_viaje;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    @Override
    public String toString() {
        return "Viaje_evento [id_viaje=" + id_viaje + ", id_evento=" + id_evento + "]";
    }
    
}
