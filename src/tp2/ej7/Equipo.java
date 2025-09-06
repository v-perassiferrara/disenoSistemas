package tp2.ej7;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipo {
    private int codigo;
    private String entrenador;
    private List<Esquiador> esquiadores;
    private int cantidadMiembros;
}