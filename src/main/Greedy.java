package src.main;
import java.util.*;

public class Greedy {

 public Solucion greedy (List<Paquete> paquetes, List<Camion> camiones) {
        Solucion resultado = new Solucion();
        paquetes.sort(Comparator.comparing(Paquete::getPeso_kg).reversed());
        for (Paquete p : paquetes) {
            boolean asignado = false;
            for (Camion c : camiones) {
                resultado.setMetrica(resultado.getMetrica() + 1);
                if (!asignado && c.puedeTransportar(p)){
                    c.agregarPaquete(p);
                    resultado.agregarAsignacion(c, p);
                        asignado=true;
                        break; // ver esto, con el break da 9 candidatos 
                              // sin el break da 12 candidatos
                }
        }
        if (!asignado){
            resultado.agregarPesoNoAsignado(p);
        }
                }
        return resultado;
    }
}
