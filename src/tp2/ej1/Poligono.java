package tp2.ej1;

import java.util.ArrayList;
import java.util.List;

public abstract class Poligono extends Figura {

    protected List lados;


    //Constructores

    public Poligono() {
    }

    public Poligono(List lados) {
        this.lados = new ArrayList<Lado>(3);
    }


    //Get&Set

    public List getLados() {
        return lados;
    }

    public void setLados(List lados) {
        this.lados = lados;
    }

}
