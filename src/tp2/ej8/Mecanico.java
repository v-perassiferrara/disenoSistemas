package tp2.ej8;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(exclude = "serviciosHechos")
@EqualsAndHashCode(exclude = "serviciosHechos")
public class Mecanico extends Persona {
    private Long id;
    private String turno;
    private int salario;
    @Builder.Default
    private Set<TipoAvion> tiposAvionCertificados = new HashSet<>();
    @Builder.Default
    private Set<Servicio> serviciosHechos = new HashSet<>();



    public String agregarCertificacion(TipoAvion tipoAvion) {
        this.tiposAvionCertificados.add(tipoAvion);
        return "Certificado para " +  tipoAvion + " agregado";
    }

    public String registrarServicio(Servicio servicio) {

        // validar que no exista ya
        if (serviciosHechos.contains(servicio)) {
            return "Ya existe un servicio para este avión en la fecha " +
                    servicio.getFecha() + " con el tipo '" + servicio.getTipo() + "'";
        }

        serviciosHechos.add(servicio);
        return "Servicio " + servicio + " registrado correctamente por el mecánico";
    }
}
