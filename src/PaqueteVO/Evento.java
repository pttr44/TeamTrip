package PaqueteVO;

import java.time.LocalDateTime;

public class Evento {
    private int id_evento;
    private LocalDateTime fecha_hora;

    public Evento(LocalDateTime fecha_hora, int id_evento) {
        this.fecha_hora = fecha_hora;
        this.id_evento = id_evento;
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

    @Override
    public String toString() {
        return "Evento [id_evento=" + id_evento + ", fecha_hora=" + fecha_hora + "]";
    }

}
