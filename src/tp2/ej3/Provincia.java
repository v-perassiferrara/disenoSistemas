package tp2.ej3;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@ToString(exclude = "ciudades")

public class Provincia {

    private String nombre;
    private int habitantes;
    private Pais pais;
    @Builder.Default
    private List<Ciudad> ciudades = new ArrayList<>();



    public void agregarCiudad(Ciudad ciudad){
        this.ciudades.add(ciudad);
    }

    public double getPorcentajeCiudadesDeficit() {
        int ciudadesDeficit = 0;

        for (Ciudad ciudad : ciudades) {
            if (ciudad.calcularBalance() < 0 && ciudad.getHabitantes() > 100000){
                ciudadesDeficit++;
            }
        }

        return ((double)ciudadesDeficit / ciudades.size()) * 100;   // Porcentaje con déficit
    }
}
