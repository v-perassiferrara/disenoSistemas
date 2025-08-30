package tp2.ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lado {

    private List puntos;


    //Constructores

    public Lado() {
    }

    public Lado(List puntos) {
        this.puntos = new ArrayList<Punto>(2);
    }


    //Get & Set

    public List getPuntos() {
        return Collections.unmodifiableList(puntos);
    }

    public void agregarPunto(List punto) {
        if (punto != null && !puntos.contains(punto)) {
            puntos.add(punto);
        }
    }

}
