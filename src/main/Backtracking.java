package src.main;

import java.util.*;

public class Backtracking {
    private Solucion mejorSolucion;
    private double menorPesoPerdido;
    private int cantidadEstados;

    public Solucion backtracking(List<Paquete> paquetes, List<Camion> camiones) {
        mejorSolucion = null;
        menorPesoPerdido = Double.MAX_VALUE;
        cantidadEstados = 0;

        back(paquetes, camiones, 0, 0);
        if (mejorSolucion != null) {
            mejorSolucion.setMetrica(cantidadEstados);
        }

        return mejorSolucion;
    }

    /*
     * ESTRATEGIA:
     Usamos backtracking para recorrer todas las combinaciones posibles de carga.
     En cada paso, agarramos el 'paqueteActual' y probamos meterlo en cada camión disponible que tenga espacio y cumpla con las reglas (capacidad de carga y refrigeración).
     Además de probar los camiones, probamos todas las opciones: o meter el paquete en los camiones o dejarlo afuera. 
     No dar por sentado que hay que subir un paquete solo porque hay espacio nos asegura que el algoritmo analice todas las variables y encuentre la distribución más eficiente de todas.
     Realizamos la poda: : si el peso perdido que venimos acumulando ya iguala o supera al mejor 'menorPesoPerdido', esa rama se descarta y volvemos atrás. 
     Si logramos pasar todas las podas y llegamos al final de  la lista de paquetes, encontramos un nuevo 'menorPesoPerdido', guardamos la solución y se actualiza la métrica.
     */

    private void back(List<Paquete> paquetes, List<Camion> camiones, int paqueteActual, double pesoPerdidoActual) {

        cantidadEstados++;

        if (pesoPerdidoActual < menorPesoPerdido) {

            if (paqueteActual == paquetes.size()) {
                menorPesoPerdido = pesoPerdidoActual;
                guardarMejorSolucion(camiones, pesoPerdidoActual);
            } else {
                Paquete p = paquetes.get(paqueteActual);

                for (Camion c : camiones) {
                    if (c.puedeTransportar(p)) {
                        c.agregarPaquete(p);
                        back(paquetes, camiones, paqueteActual + 1, pesoPerdidoActual);
                        c.eliminarPaquete(p);
                    }
                }
                back(paquetes, camiones,
                        paqueteActual + 1,
                        pesoPerdidoActual + p.getPeso_kg());
            }
        }
    }

    private void guardarMejorSolucion(List<Camion> camiones, double pesoPerdidoActual) {
        Solucion s = new Solucion();
        s.setPesoNoAsignado(pesoPerdidoActual);
        s.setMetrica(cantidadEstados);
        for (Camion c : camiones) {
            for (Paquete p : c.getPaquetes()) {
                s.agregarAsignacion(c, p);
            }
        }
        mejorSolucion = s;

    }
}
