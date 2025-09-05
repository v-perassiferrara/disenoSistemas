package tp2.ej1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString

public abstract class Figura {

    protected String nombre;

    protected Figura(String nombre) {
        this.nombre = nombre;
        System.out.println("Figura creada");
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    protected abstract double area();
    protected abstract double perimetro();

    @Override public String toString() {
        return getClass().getSimpleName() + "(" + nombre + ")";
    }
}