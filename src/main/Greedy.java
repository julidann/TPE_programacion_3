package src.main;

import java.util.*;

public class Greedy {

    /*
     * public Solucion greedy (List<Paquete> paquetes, List<Camion> camiones) {
     * Solucion resultado = new Solucion();
     * paquetes.sort(Comparator.comparing(Paquete::getPeso_kg).reversed());
     * for (Paquete p : paquetes) {
     * boolean asignado = false;
     * for (Camion c : camiones) {
     * resultado.setMetrica(resultado.getMetrica() + 1);
     * if (!asignado && c.puedeTransportar(p)){
     * c.agregarPaquete(p);
     * resultado.agregarAsignacion(c, p);
     * asignado=true;
     * break; // ver esto, con el break da 9 candidatos
     * // sin el break da 12 candidatos
     * }
     * }
     * if (!asignado){
     * resultado.agregarPesoNoAsignado(p);
     * }
     * }
     * return resultado;
     * }
     */
    /*
     * /*
     * /*
     * Se ordenan los paquetes y camiones de mayor a menor peso/capacidad
     * (O(n log n) y O(m log m)). Cada paquete se asigna al primer camión
     * con capacidad suficiente que cumpla las restricciones (refrigeración
     * si contiene alimentos). Complejidad total: O(n log n + m log m + n*m).
     * Así los paquetes más pesados ocupan los camiones de mayor capacidad,
     * minimizando los paquetes que quedan sin asignar.
     */
    public Solucion greedy(List<Paquete> paquetes, List<Camion> camiones) {
        Solucion resultado = new Solucion();
        paquetes.sort(Comparator.comparing(Paquete::getPeso_kg).reversed());
        camiones.sort(Comparator.comparing(Camion::getCapacidad_disponible).reversed());

        for (Paquete p : paquetes) {
            boolean asignado = false;
            for (Camion c : camiones) {
                resultado.setMetrica(resultado.getMetrica() + 1);
                if (c.puedeTransportar(p)) {
                    c.agregarPaquete(p);
                    resultado.agregarAsignacion(c, p);
                    asignado = true;
                    break;
                }
            }
            if (!asignado) {
                resultado.agregarPesoNoAsignado(p);
            }
        }
        return resultado;
    }
}
/*
 * for (Paquete p : paquetes) {
 * Camion mejor = null;
 * 
 * for (Camion c : camiones) {
 * resultado.setMetrica(resultado.getMetrica() + 1);
 * if (c.puedeTransportar(p)) {
 * if (mejor == null || c.getCapacidad_disponible() <
 * mejor.getCapacidad_disponible()) {
 * mejor = c;
 * }
 * }
 * }
 * if (mejor != null) {
 * mejor.agregarPaquete(p);
 * resultado.agregarAsignacion(mejor, p);
 * } else {
 * resultado.agregarPesoNoAsignado(p);
 * }
 * }
 * return resultado;
 * }
 */
