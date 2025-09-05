package tp2.ej2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode

public class Ciudad {
    private String nombre;
    private Provincia provincia;
    private boolean capital;

    public Ciudad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() { return this.nombre; }


    public void setCapital() {
        this.capital = true;
    }
}
