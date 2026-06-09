package src.main;
import java.util.*;

public class Solucion {
    private Map<Camion, List<Paquete>> asignacion;
    private double pesoNoAsignado;
    private int metrica; // Cantidad de estados (Backtracking) o candidatos (Greedy)

    public Solucion() {
        this.asignacion = new HashMap<>();
        this.pesoNoAsignado = 0;
        this.metrica = 0;
    }

    public void agregarAsignacion(Camion camion, Paquete paquete) {

        if (!asignacion.containsKey(camion)) {
            asignacion.put(camion, new ArrayList<>());
        }

        asignacion.get(camion).add(paquete);
    }

    public void agregarPesoNoAsignado(Paquete paquete) {
    pesoNoAsignado += paquete.getPeso_kg();
    }

    public double getPesoNoAsignado() {
        return pesoNoAsignado;
    }

    public void setPesoNoAsignado(double pesoNoAsignado) {
        this.pesoNoAsignado = pesoNoAsignado;
    }

    public int getMetrica() {
        return metrica;
    }

    public void setMetrica(int metrica) {
        this.metrica = metrica;
    }

        //HACER EL TOSTRING
        // PARA RETORNAR EL CAMIÓN Y LOS PAQUETES

   @Override
public String toString() {

    String resultado = "";

    for (Camion camion : asignacion.keySet()) {

        resultado += "\n____________________________________________________________\n";
        resultado += "ID Camión: " + camion.getId_camion();
        resultado += " \nPatente: " + camion.getPatente();
        resultado += " \nCapacidad: " + camion.getCapacidad_kg() + " kg";
        resultado += " \nRefrigerado: " + camion.isEsta_refrigerado();
        resultado += " \nPaquetes asignados:\n";

        for (Paquete paquete : asignacion.get(camion)) {

            resultado += "\n- Código paquete: " + paquete.getCodigo_paquete();
            resultado += "\n- Peso: " + paquete.getPeso_kg() + " kg";
            resultado += "\n- Urgencia: " + paquete.getNivel_urgencia();
            resultado += "\n- Alimentos: " + paquete.isContiene_alimentos();
            resultado += "\n";
        }
    }
    resultado += "\n____________________________________________________________\n";
    resultado += "Peso no asignado: " + pesoNoAsignado + " kg\n";

    return resultado;
}




}

