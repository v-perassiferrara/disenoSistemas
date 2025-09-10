package tp2.ej8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Piloto extends Persona {
    private Long id;
    private int numeroLicencia;
    private String restricciones;
    @Builder.Default
    private Set<TipoAvion> tiposAvionPermitidos = new HashSet<>();



    public String agregarPermiso(TipoAvion tipoAvion) {
        this.tiposAvionPermitidos.add(tipoAvion);
        return "Permiso para " +  tipoAvion + " agregado";
    }
}