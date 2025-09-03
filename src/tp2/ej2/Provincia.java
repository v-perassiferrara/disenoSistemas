package Ejercicio2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString

public class Provincia {
    private String nombre;
    private Pais pais;

    public Provincia(String nombre, Pais pais) {

        if (nombre == null || pais == null ) throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
        this.nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() { return this.nombre; }

    public Pais getPais() { return this.pais; }

}
