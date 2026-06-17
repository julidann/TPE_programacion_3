package src.main;

import java.util.*;

public class Backtracking {
    private Solucion mejorSolucion;
    private double menorPesoPerdido;
    private int cantidad;

    public Solucion backtracking(List<Paquete> paquetes, List<Camion> camiones) {
        mejorSolucion = null;
        menorPesoPerdido = Double.MAX_VALUE;
        cantidad = 0;

        back(paquetes, camiones, 0, 0);
        mejorSolucion.setMetrica(cantidad);
        return mejorSolucion;
    }

    private void back(List<Paquete> paquetes, List<Camion> camiones, int index, double pesoPerdidoActual) {
        cantidad++;
        if (index == paquetes.size()) {
            if (pesoPerdidoActual < menorPesoPerdido) {
                menorPesoPerdido = pesoPerdidoActual;
                guardarMejorSolucion(camiones, pesoPerdidoActual);
            }
        } else if (pesoPerdidoActual < menorPesoPerdido) {
            Paquete p = paquetes.get(index);
            boolean asigno = false;
            for (Camion c : camiones) {
                if (c.puedeTransportar(p)) {
                    c.agregarPaquete(p);
                    back(paquetes, camiones, index + 1, pesoPerdidoActual);
                    asigno = true;
                    c.eliminarPaquete(p);
                }
            }
            if (!asigno)
                back(paquetes, camiones, index + 1, pesoPerdidoActual + p.getPeso_kg());

        }
    }

    private void guardarMejorSolucion(List<Camion> camiones,
            double pesoPerdidoActual) {
        Solucion s = new Solucion();
        s.setPesoNoAsignado(pesoPerdidoActual);
        s.setMetrica(cantidad);
        for (Camion c : camiones) {
            for (Paquete p : c.getPaquetes()) {
                s.agregarAsignacion(c, p);
            }
        }
        mejorSolucion = s;

    }
}