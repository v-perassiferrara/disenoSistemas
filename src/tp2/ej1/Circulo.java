package tp2.ej1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString

public class Circulo extends Elipse {
    private double radio;

    public Circulo(Punto centro, double radio) {
        super(centro, radio, radio);
        this.radio = radio;
    }
    public double getRadio() { return radio; }

    @Override public String getNombre() { return "Círculo"; }
    @Override public double area() { return Math.PI * radio * radio; }
    @Override public double perimetro() { return 2 * Math.PI * radio; }
}

