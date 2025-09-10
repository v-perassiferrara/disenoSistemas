package tp2.ej8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hangar {
    private Long id;
    private int numero;
    private int capacidad;
    private String ubicacion;
    @Builder.Default
    private Set<Avion> aviones = new HashSet<>();   // HashSet para evitar duplicados



    public String agregarAvion(Avion avion) {
        if (aviones.size() < this.capacidad) {
            aviones.add(avion);
            return "Avión " + avion + " agregado al hangar";
        }
        return "El hangar está lleno";
    }

    public String eliminarAvion(Avion avion) {
        if (aviones.contains(avion)) {
            aviones.remove(avion);
            return "Avión " + avion + " eliminado del hangar";
        }
        return "El avión" + avion + "no está en el hangar indicado";
    }
    }
