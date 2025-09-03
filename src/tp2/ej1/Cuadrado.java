package Ejercicio1;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
@EqualsAndHashCode
@ToString

public class Cuadrado extends Rectangulo {

    public Cuadrado(List<Lado> lados ) {
        super("Cuadrado", lados);
        double lado = lados.getFirst().longitud();
        for (Lado l : lados) {
            if (Math.abs(l.longitud() - lado) > 1e-9) {
                throw new IllegalArgumentException("Un cuadrado debe tener los 4 lados iguales.");
            }
        }
        System.out.println("Cuadrado creado");
    }
    @Override
    public String getNombre() { return "Cuadrado"; }
}
