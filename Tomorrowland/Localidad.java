package Tomorrowland;
import java.util.Random;

public class Localidad {
    private String nombre;
    private double precio;
    private int capacidad = 20;
    private int boletosVendidos;

    public Localidad() {
        asignarLocalidadAleatoria();
    }

    private void asignarLocalidadAleatoria() {
        String[] localidades = {"Localidad 1", "Localidad 5", "Localidad 10"};
        double[] precios = {400.0, 695.0, 2350.0};

        Random random = new Random();
        int indice = random.nextInt(localidades.length);

        this.nombre = localidades[indice];
        this.precio = precios[indice];
    }

    public int validarBoletos(int cantidadSolicitada) {
        int boletosDisponibles = capacidad - boletosVendidos;
        return Math.min(boletosDisponibles, cantidadSolicitada);
    }

    public boolean hayEspacio() {
        return boletosVendidos < capacidad;
    }

    public void comprarBoletos(int cantidad) {
        boletosVendidos += cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
