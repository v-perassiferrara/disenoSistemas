package Ejercicio1;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@Data
@EqualsAndHashCode
@ToString

public class Triangulo {
    private String tipoTriangulo;

    public Triangulo(List<Lado> lados) {

        if (lados.size() != 3) {
            throw new IllegalArgumentException("Un triángulo debe tener 3 lados.");
        }

        if (lados.get(0).longitud() == lados.get(1).longitud() && lados.get(1).longitud() == lados.get(2).longitud()) {
            this.tipoTriangulo = "Equilatero";
        } else if (lados.get(0).longitud() == lados.get(1).longitud() || lados.get(1).longitud() == lados.get(2).longitud() || lados.get(0).longitud() == lados.get(2).longitud()) {
            this.tipoTriangulo = "Isoceles";
        } else {
            this.tipoTriangulo = "Escaleno";
        }
    }
}

