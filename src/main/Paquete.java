package src.main;

public class Paquete {
    private int id_paquete;
    private String codigo_paquete;
    private double peso_kg;
    private boolean contiene_alimentos;
    private int nivel_urgencia;

    public Paquete(int id_paquete, String codigo_paquete, double peso_kg, boolean contiene_alimentos,
            int nivel_urgencia) {
        this.id_paquete = id_paquete;
        this.codigo_paquete = codigo_paquete;
        this.peso_kg = peso_kg;
        this.contiene_alimentos = contiene_alimentos;
        if (nivel_urgencia >= 1 && nivel_urgencia <= 100) {
            this.nivel_urgencia = nivel_urgencia;
        } else {
            this.nivel_urgencia = 1;
        }
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(int id_paquete) {
        this.id_paquete = id_paquete;
    }

    public String getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(String codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public boolean isContiene_alimentos() {
        return contiene_alimentos;
    }

    public void setContiene_alimentos(boolean contiene_alimentos) {
        this.contiene_alimentos = contiene_alimentos;
    }

    public int getNivel_urgencia() {
        return nivel_urgencia;
    }

    public void setNivel_urgencia(int nivel_urgencia) {
        if (nivel_urgencia < 1 || nivel_urgencia > 100) {
            System.out.println("Error: el nivel de urgencia debe ser un numero entre 1 y 100");
        } else {
            this.nivel_urgencia = nivel_urgencia;
        }
    }

@Override
public String toString() {
    return "\n__________________________" +
           "\nID paquete: " + id_paquete +
           "\nCódigo paquete: " + codigo_paquete +
           "\nPeso: " + peso_kg + " kg" +
           "\nContiene alimentos: " + contiene_alimentos +
           "\nNivel de urgencia: " + nivel_urgencia;           
}
}
