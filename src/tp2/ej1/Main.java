package tp2.ej1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Lado> listaLadosCuadrado = new ArrayList<>();
        Lado lado1 = new Lado(new Punto(0, 0), new Punto(1, 0));
        Lado lado2 = new Lado(new Punto(0, 0), new Punto(0, 1));
        Lado lado3 = new Lado(new Punto(1, 0), new Punto(1, 1));
        Lado lado4 = new Lado(new Punto(0, 1), new Punto(1, 1));
        listaLadosCuadrado.add(lado1);
        listaLadosCuadrado.add(lado2);
        listaLadosCuadrado.add(lado3);
        listaLadosCuadrado.add(lado4);
        for (int i = 0; i < listaLadosCuadrado.size(); i++){
            System.out.println(listaLadosCuadrado.get(i));
        }
        Cuadrado cuadrado = new Cuadrado(listaLadosCuadrado);
        System.out.println(cuadrado);


        List<Lado> listaLadosTriangulo = new ArrayList<>();
        Lado lado5 = new Lado(new Punto(0, 0), new Punto(1, 0));
        Lado lado6 = new Lado(new Punto(0, 0), new Punto(0, 1));
        Lado lado7 = new Lado(new Punto(1, 0), new Punto(0, 1));
        listaLadosTriangulo.add(lado5);
        listaLadosTriangulo.add(lado6);
        listaLadosTriangulo.add(lado7);
        Triangulo isoceles = new Triangulo(listaLadosTriangulo);
        System.out.println(isoceles);

        Circulo circulo = new Circulo(new Punto(0, 0), 1);
        System.out.println(circulo);
    }
}