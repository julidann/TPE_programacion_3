package src.main;
//import src.reader.CSVreader;

public class Main {

    public static void main(String[] args) {
        
        Servicios servicios = new Servicios("src/csv/Camiones.csv", "src/csv/Paquetes.csv");
        System.err.println("PARTE 1: SOLUCIÓN SERVICIOS:\n");
        System.out.println("SERVICIO 1:");
        System.out.println(servicios.servicio1("P001"));
        System.out.println(servicios.servicio1("P002"));
        System.out.println(servicios.servicio1("P003"));
        System.out.println(servicios.servicio1("P004"));

        System.out.println("\nEjemplo código que no existe:\n");
        System.out.println(servicios.servicio1("P005"));

    
        System.out.println("\nSERVICIO 2:");
        System.out.println("\nPAQUETES QUE CONTIENEN ALIMENTOS:\n");
        System.out.println(servicios.servicio2(true));

        System.out.println("\nPAQUETES QUE NO CONTIENEN ALIMENTOS:\n");
        System.out.println(servicios.servicio2(false));

        System.out.println("\nSERVICIO 2:");
        int minimo = 1;
        int maximo = 100;
        System.out.println("\nPAQUETES CON NIVEL DE URGENCIA ENTRE " + minimo + " y " + maximo + ":\n");
        System.out.println(servicios.servicio3(minimo, maximo));

    /*GREEDY */

    Greedy g = new Greedy();

    Solucion greedy = g.greedy( servicios.getPaquetes(), servicios.getCamiones());
    System.out.println("\nSOLUCIÓN GREEDY");
    System.out.println(greedy);
    System.out.println("Candidatos considerados: " + greedy.getMetrica());

    /*BACKTRACKING*/
    Servicios servicios2 = new Servicios("src/csv/Camiones.csv", "src/csv/Paquetes.csv");
    Backtracking b = new Backtracking();
    Solucion backtracking =b.backtracking(servicios2.getPaquetes(), servicios2.getCamiones());

    System.out.println("\nSOLUCIÓN BACKTRACKING");
    System.out.println(backtracking);
    System.out.println("Estados generados: "+ backtracking.getMetrica());
}

}