package tp2.ej7;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Federacion {
    private List<Estacion> estaciones;   // porque la Federación regula estaciones
    private String nombre;
    private int cantFederados;
}