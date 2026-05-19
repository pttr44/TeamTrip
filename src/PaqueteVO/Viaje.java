package PaqueteVO;

import java.time.LocalDate;

public class Viaje {
    private  int id_viaje;
    private  LocalDate fecha_inicio;
    private  LocalDate fecha_fin;
    
    public Viaje(int id_viaje, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_viaje = id_viaje;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Viaje [id_viaje=" + id_viaje + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + "]";
    }

}
