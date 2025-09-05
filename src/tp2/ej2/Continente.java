package tp2.ej2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString

public class Continente {
    private String nombre;

    public Continente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return this.nombre; }
}



