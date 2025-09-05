package tp2.ej1;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@EqualsAndHashCode
@ToString


abstract class Poligono extends Figura {

    protected List<Lado> lados;

    protected Poligono(String nombre, List<Lado> lados) {
        super(nombre);
        this.nombre = nombre;
        this.lados = lados;
        System.out.println("Poligono creado");
    }

}