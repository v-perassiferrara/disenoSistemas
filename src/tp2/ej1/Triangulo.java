package tp2.ej1;

import java.util.List;

public class Triangulo extends Poligono {

    public Triangulo(List<Lado> lados) {
        if (lados.size() != 3) {    // Verifica que tenga 3 lados
            throw new IllegalArgumentException("Un triángulo debe tener 3 lados");
        }
    }

}
