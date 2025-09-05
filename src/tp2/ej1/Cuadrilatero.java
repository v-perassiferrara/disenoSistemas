package tp2.ej1;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString

public abstract class Cuadrilatero extends Poligono {
    protected Cuadrilatero(String nombre, List<Lado> lados){
        super(nombre, lados);
        if (lados == null || lados.size() != 4)
            throw new IllegalArgumentException("Un cuadrilátero debe tener 4 lados.");

        System.out.println("Cuadrilatero creado");
    }

    @Override
    protected double perimetro() {
        double p = 0.0;
        for (Lado l : this.lados) {
            p += l.longitud();
        }
        return p;
    }

    @Override
    protected abstract double area();
}
