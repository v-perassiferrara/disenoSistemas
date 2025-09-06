package tp2.ej4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 🔹 Minerales
        Mineral cobre = new Mineral("Cobre", Boolean.FALSE);
        Mineral plata = new Mineral("Plata", Boolean.FALSE);
        Mineral potasio = new Mineral("Potasio", Boolean.TRUE);
        Mineral fosforo = new Mineral("Fósforo", Boolean.TRUE);

        // 🔹 Cereales
        Grano trigo = Grano.builder()
                .nombre("Trigo")
                .isGrueso(false)
                .mineralesNecesarios(Arrays.asList(cobre, fosforo))
                .build();

        Grano maiz = Grano.builder()
                .nombre("Maíz")
                .isGrueso(true)
                .mineralesNecesarios(Arrays.asList(potasio, fosforo))
                .build();

        Pastura alfalfa = Pastura.builder()
                .nombre("Alfalfa")
                .mineralesNecesarios(Arrays.asList(plata, potasio))
                .build();

        List<Cereal> todosLosCereales = Arrays.asList(trigo, maiz, alfalfa);

        // 🔹 Lotes
        Lote lote1 = Lote.builder()
                .cultivoPrevio(null)
                .minerales(Arrays.asList(potasio, fosforo, cobre))
                .build();

        Lote lote2 = Lote.builder()
                .cultivoPrevio("tp2.ej4.Pastura")
                .minerales(Arrays.asList(plata, cobre))
                .build();

        Lote lote3 = Lote.builder()
                .cultivoPrevio(null)
                .minerales(Arrays.asList(plata, cobre, fosforo))
                .build();

        // 🔹 Verificar si son especiales
        lote1.verificarSiEsEspecial();
        lote2.verificarSiEsEspecial();
        lote3.verificarSiEsEspecial();

        System.out.println("=== Estado de los lotes ===");
        System.out.println("Lote1 es especial? " + lote1.getEsEspecial());
        System.out.println("Lote2 es especial? " + lote2.getEsEspecial());
        System.out.println("Lote3 es especial? " + lote3.getEsEspecial());

        // 🔹 Ver qué cereales se pueden sembrar
        System.out.println("\n=== Cereales aconsejados por lote ===");
        System.out.println("Lote1: " + lote1.cerealesAconsejados(todosLosCereales));
        System.out.println("Lote2: " + lote2.cerealesAconsejados(todosLosCereales));
        System.out.println("Lote3: " + lote3.cerealesAconsejados(todosLosCereales));
    }
}