package src.main;
import java.util.*;

import src.reader.CSVreader;

public class Servicios { 
    //Completar con las estructuras y métodos privados que se requieran. 
    private String pathCamiones;
    private String pathPaquetes;
    private List<Camion> camiones;
    private List<Paquete> paquetes;

    private HashMap<String, Paquete> paquetePorCodigo;
    private HashMap<Boolean, List<Paquete>> paquetePorAlimentos;
    private TreeMap<Integer, List<Paquete>> paquetesPorUrgencia;


    public List<Paquete> getPaquetes() {
        return new ArrayList<>(paquetes);
    }

    public List<Camion> getCamiones() {
        return new ArrayList<>(camiones);
    }
        /* 
     * Expresar la complejidad temporal del constructor. 
     */ 
    public Servicios(String pathCamiones, String pathPaquetes){ 
  
        paquetePorCodigo = new HashMap<>();
        paquetePorAlimentos = new HashMap<>();
        paquetePorAlimentos.put(true, new ArrayList<>());
        paquetePorAlimentos.put(false, new ArrayList<>());
        paquetesPorUrgencia = new TreeMap<>();
            
        CSVreader reader = new CSVreader();

        this.paquetes = reader.leerPaquetes(pathPaquetes);

        this.camiones = reader.leerCamiones(pathCamiones);

        for (Paquete p : paquetes) {

        paquetePorCodigo.put(p.getCodigo_paquete(), p);

        paquetePorAlimentos
                .get(p.isContiene_alimentos()).add(p);

        if (!paquetesPorUrgencia.containsKey(p.getNivel_urgencia())) {
            paquetesPorUrgencia.put(p.getNivel_urgencia(),new ArrayList<>());
        }
        paquetesPorUrgencia.get(p.getNivel_urgencia()).add(p);
        }
        
    }
    /* 
     * Expresar la complejidad temporal del servicio 1: 
    O(1) porque usa HashMap
     */ 
    public Paquete servicio1(String codigoPaquete) {
        return paquetePorCodigo.get(codigoPaquete);
    }
    /* 
     * Expresar la complejidad temporal del servicio 2:
        O(1) porque las listas ya están separadas
     */ 
    public List<Paquete> servicio2(boolean contieneAlimentos) {
        return paquetePorAlimentos.get(contieneAlimentos);
    }
    /* 
     * Expresar la complejidad temporal del servicio 3:
    O(log n + k) 
     */ 
    public List<Paquete> servicio3(int min, int max) {

        List<Paquete> resultado = new ArrayList<>();
        Set<Integer> urgencias = paquetesPorUrgencia.keySet();
        if (min>=1 && max<=100){
        for (Integer urgencia : urgencias) {

            if (urgencia >= min && urgencia <= max) {

                resultado.addAll(paquetesPorUrgencia.get(urgencia));
            }
        }
        return resultado;
}else{
    System.out.println("Por favor ingrese un número entre 1 y 100");
}   
return null;

 
}
}