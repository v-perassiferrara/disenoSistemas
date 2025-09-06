package tp2.ej7;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pista {
    private int id;
    private int codigoEstacion;
    private int longitud;
    private String dificultad;
}