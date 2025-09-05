package tp2.ej1;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static java.lang.Math.*;

@EqualsAndHashCode
@ToString

public class Elipse extends Figura {
    private final Punto centro;
    private final double semiejeMayor; // semieje mayor
    private final double semiejeMenor; // semieje menor
    private String tipo;

    public Elipse(Punto centro, double semiejeMayor, double semiejeMenor) {
        super("Elipse");
        if (semiejeMayor <= 0 || semiejeMenor <= 0) throw new IllegalArgumentException("Semiejes deben ser> 0");
        this.semiejeMayor = semiejeMayor; this.semiejeMenor = semiejeMenor;
        if (semiejeMayor == semiejeMenor){
            this.tipo = "Circulo";
        }
        this.centro = centro;
    }
    public double getA() { return semiejeMayor; }
    public double getB() { return semiejeMenor; }

    public Punto getCentro() { return centro; }

    @Override public double area() { return PI * semiejeMayor * semiejeMenor; }

    // Aproximación de Ramanujan para el perímetro
    @Override public double perimetro() {
        double h = pow(semiejeMayor - semiejeMenor, 2) / pow(semiejeMayor + semiejeMenor, 2);
        return PI * (semiejeMayor + semiejeMenor) * (1 + (3*h) / (10 + sqrt(4 - 3*h)));
    }
}

