package src.main;
import java.util.*;

public class Camion {
    private int id_camion;
    private String patente;
    private boolean esta_refrigerado;
    private double capacidad_kg;
    private List<Paquete> paquetes;
    private double capacidad_disponible;

    public Camion(int id_camion, String patente, boolean esta_refrigerado, double capacidad_kg) {
        this.id_camion = id_camion;
        this.patente = patente;
        this.esta_refrigerado = esta_refrigerado;
        this.capacidad_kg = capacidad_kg;
        paquetes = new ArrayList<>();
        this.capacidad_disponible = capacidad_kg;
    }

    public void agregarPaquete(Paquete p) {
        paquetes.add(p);
        capacidad_disponible -= p.getPeso_kg();
    }

    public void eliminarPaquete(Paquete p) {
        paquetes.remove(p);
        capacidad_disponible += p.getPeso_kg();
    }

    public boolean puedeTransportar(Paquete p) {

        if (capacidad_disponible < p.getPeso_kg()) {
            return false;
        }

        if (p.isContiene_alimentos() && !isEsta_refrigerado()) {
            return false;
        }

        return true;
    }

    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public int getId_camion() {
        return id_camion;
    }

    public void setId_camion(int id_camion) {
        this.id_camion = id_camion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public boolean isEsta_refrigerado() {
        return esta_refrigerado;
    }

    public void setEsta_refrigerado(boolean esta_refrigerado) {
        this.esta_refrigerado = esta_refrigerado;
    }

    public double getCapacidad_kg() {
        return capacidad_kg;
    }

    public void setCapacidad_kg(double capacidad_kg) {
        this.capacidad_kg = capacidad_kg;
    }

    public double getCapacidad_disponible() {
        return capacidad_disponible;
    }


    @Override
public String toString() {
    return "\n__________________________" +
           "\nID Camión: " + id_camion +
           "\nPatente: " + patente +
           "\nRefrigerado: " + esta_refrigerado +
           "\nCapacidad total: " + capacidad_kg + "kg" + 
           "\nCapacidad disponible: " + capacidad_disponible;           
}
}
