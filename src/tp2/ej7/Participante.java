package tp2.ej7;

import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Participante {
    private Prueba prueba;
    private Pista pista;
    private LocalDateTime fecha;
    private String codigo;
    private boolean vencedor;
    private LocalTime tiempo;
    private int posicion;
}