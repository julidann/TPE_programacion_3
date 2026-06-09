package src.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import src.main.Camion;
import src.main.Paquete;

public class CSVreader {

    public ArrayList<Paquete> leerPaquetes(String path) {

        ArrayList<Paquete> paquetes = new ArrayList<>();
        ArrayList<String[]> lines = readContent(path);

        // salteo la primera línea (cantidad de paquetes)
        for (int i = 1; i < lines.size(); i++) {

            String[] line = lines.get(i);

            int id = Integer.parseInt(line[0].trim());
            String codigo = line[1].trim();
            double peso = Double.parseDouble(line[2].trim());
            boolean alimentos = line[3].trim().equals("1");
            int urgencia = Integer.parseInt(line[4].trim());

            Paquete paquete =
                    new Paquete(id, codigo, peso,
                            alimentos, urgencia);

            paquetes.add(paquete);
        }

        return paquetes;
    }

    public ArrayList<Camion> leerCamiones(String path) {

        ArrayList<Camion> camiones = new ArrayList<>();
        ArrayList<String[]> lines = readContent(path);

        // salteo la primera línea (cantidad de camiones)
        for (int i = 1; i < lines.size(); i++) {

            String[] line = lines.get(i);

            int id = Integer.parseInt(line[0].trim());
            String patente = line[1].trim();
            boolean refrigerado = line[2].trim().equals("1");
            double capacidad = Double.parseDouble(line[3].trim());

            Camion camion =
                    new Camion(id, patente, refrigerado, capacidad);

            camiones.add(camion);
        }

        return camiones;
    }

    private ArrayList<String[]> readContent(String path) {

        ArrayList<String[]> lines = new ArrayList<>();

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader(new File(path)));

            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                lines.add(line.split(";"));
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}