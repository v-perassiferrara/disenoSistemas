package tp2.ej7;

import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Prueba {
    private String nombre;
    private String tipo;
    private LocalDateTime fechasPrevistas;
    private Pista pista;
    private String vencedor;
    private LocalTime tiempoVictoria;

}