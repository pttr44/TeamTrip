package PaqueteVO;

public class Precio {
    private int id_precio;
    private double valor;

    public Precio(int id_precio, double valor) {
        this.id_precio = id_precio;
        this.valor = valor;
    }

    public int getId_precio() {
        return id_precio;
    }

    public void setId_precio(int id_precio) {
        this.id_precio = id_precio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
