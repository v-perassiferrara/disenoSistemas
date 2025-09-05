package tp2.ej1;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@EqualsAndHashCode
@ToString

public class Rectangulo extends Cuadrilatero {
    private final double base;
    private final double altura;

    public Rectangulo(String nombre, List<Lado> lados) {
        super(nombre, lados);
        if (nombre == "Cuadrado"){
            this.base = lados.get(0).longitud();
            this.altura = lados.get(0).longitud();
        }else{
            List<Double> longitudesLados = esRectangulo(lados);
            this.base = longitudesLados.get(0);
            this.altura = longitudesLados.get(1);
        }
        System.out.println("Rectángulo creado");
    }

    protected List<Double> esRectangulo(List<Lado> lados) {
        List<Double> longitudesLados = new ArrayList<>();
        System.out.println("Primer Checkpoint");
        for (int i = 0; i < lados.size(); i++) {
            double longitud = lados.get(i).longitud();
            System.out.println("Longitud: " + longitud);
            if (longitudesLados.contains(longitud)) {
                continue;
            }else{
                longitudesLados.add(longitud);
                System.out.println("Longitud agregada");
            }
        }
        if (longitudesLados.size() > 2) {
            throw new IllegalArgumentException("Un rectángulo debe tener 2 lados iguales.");
        }
        double base = longitudesLados.get(0);
        double altura = longitudesLados.get(1);
        longitudesLados.clear();
        longitudesLados.add(base);
        longitudesLados.add(altura);
        return longitudesLados;
    }


    @Override
    public double area() {
        return this.base * this.altura;
    }

    @Override
    public double perimetro() {
        return this.base * 2 + this.altura * 2;
    }

}



