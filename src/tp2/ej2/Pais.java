package Ejercicio2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode

public class Pais {
    private String nombre;
    private Continente continente;
    private List<Pais> paisesLimitrofes = new ArrayList<Pais>();

    public Pais(String nombre, Continente continente) {
        if (nombre == null || continente == null) throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
        this.nombre = nombre;
        this.continente = continente;
    }

    public String getNombre() { return this.nombre; }
    public Continente getContinente() { return this.continente; }
    public List<Pais> getPaisesLimitrofes() { return this.paisesLimitrofes; }

    public void setPaisLimitrofe(Pais pais) { this.paisesLimitrofes.add(pais); }
}
