package PaqueteVO;

import java.time.LocalDateTime;

public class Evento {
    private int id_evento;
    private LocalDateTime fecha_hora;
    private String nombre;

    public Evento(LocalDateTime fecha_hora, int id_evento, String nombre) {
        this.fecha_hora = fecha_hora;
        this.id_evento = id_evento;
        this.nombre = nombre;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Evento [id_evento=" + id_evento + ", fecha_hora=" + fecha_hora + ", nombre=" + nombre + "]";
    }

}
