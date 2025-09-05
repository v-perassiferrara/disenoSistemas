package tp2.ej8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Persona {
    private String nombre;
    private int numeroSeguridadSocial;
    private String direccion;
    private int telefono;
}
