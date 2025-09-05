package tp2.ej3;

import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "provincias")

public class Pais {

    private String nombre;
    @Builder.Default
    private List<Provincia> provincias = new ArrayList<>();


    public void agregarProvincia(Provincia provincia){
        this.provincias.add(provincia);
    }

    public String verificarGasto() {
        ArrayList provinciasDeficit =  new ArrayList();

        for (Provincia provincia : provincias) {
            if (provincia.getPorcentajeCiudadesDeficit() > 50.0) {
                provinciasDeficit.add(provincia.getNombre());
            }
        }

        return provinciasDeficit.toString();
    }

}
