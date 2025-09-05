package tp2.ej8;

import lombok.*;

import java.util.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "serviciosRecibidos")
@EqualsAndHashCode(exclude = "serviciosRecibidos")
public class Avion {
    private int matricula;
    private TipoAvion tipo;
    private Date fechaAdquisicion;  //del dueño actual
    private Persona propietario;    //dueño actual
    @Builder.Default
    private List<Persona> propietariosAnteriores = new ArrayList<>();
    @Builder.Default
    private Set<Servicio> serviciosRecibidos = new HashSet<>();



    public String registrarServicio(Servicio servicio) {

        // validar que no exista ya
        if (serviciosRecibidos.contains(servicio)) {
            return "Ya existe un servicio para este avión en la fecha " +
                    servicio.getFecha() + " con el tipo '" + servicio.getTipo() + "'";
        }

        serviciosRecibidos.add(servicio);
        return "Servicio " + servicio + " registrado correctamente en el avión";
    }
}
