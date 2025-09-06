package tp2.ej7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Esquiador esquiador1 = new Esquiador(12345678, "Juan Pérez",
                LocalDate.of(2000, 5, 12), 23, true);


        Pista pista1 = new Pista(1, 100, 2000, "Alta");


        Prueba prueba1 = new Prueba("Slalom", "Individual",
                LocalDateTime.of(2025, 9, 10, 10, 0),
                pista1, "Juan Pérez",
                LocalTime.of(0, 1, 25));


        Participante participante1 = new Participante(
                prueba1, pista1,
                LocalDateTime.now(), "P001",
                true, LocalTime.of(0, 1, 25), 1
        );


        Campeonato campeonato = new Campeonato(
                List.of(prueba1),
                List.of(participante1)
        );

        // print para debug
        System.out.println(campeonato);
    }

}