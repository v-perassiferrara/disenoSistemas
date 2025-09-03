package Ejercicio1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString


public class Lado {
    // Agregación de 2 puntos
    private final Punto a, b;

    public Lado(Punto a, Punto b) {
        if (a == null || b == null) throw new IllegalArgumentException("Puntos nulos");
        if (a == b) throw new IllegalArgumentException("Un lado necesita dos puntos distintos");
        this.a = a;
        this.b = b;
    }
    public Punto getA() { return a; }
    public Punto getB() { return b; }
    public double longitud() { return a.distancia(b); }
}