package tp2.ej5;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Gusto {
    private Boolean le_gusta;
    private Plato plato;
    private Sucursal sucursal;
}
