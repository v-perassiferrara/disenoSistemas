package tp2.ej8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAvion {
    private Long id;
    private int numeroModelo;
    private int capacidad;
    private int peso;

}
