package PaqueteVO;

public class Lugar {
    private int id_lugar;

    public Lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    @Override
    public String toString() {
        return "Lugar [id_lugar=" + id_lugar + "]";
    }
}


