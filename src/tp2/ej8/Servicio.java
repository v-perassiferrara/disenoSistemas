package tp2.ej8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servicio {         //Único caso donde me vi obligado a hacer "clase intermedia"
    private Long id;
    private Persona mecanico;
    private Avion avion;
    private Date fecha;
    private int duracionHoras;
    private String tipo;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicio servicio = (Servicio) o;
        return Objects.equals(avion, servicio.avion) &&
                Objects.equals(fecha, servicio.fecha) &&
                Objects.equals(tipo, servicio.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avion, fecha, tipo);
    }
}

