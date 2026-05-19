package PaqueteVO;

public class Lugar {
    private String id_lugar;

    public Lugar(String id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(String id_lugar) {
        this.id_lugar = id_lugar;
    }

    @Override
    public String toString() {
        return "Lugar [id_lugar=" + id_lugar + "]";
    }
}


