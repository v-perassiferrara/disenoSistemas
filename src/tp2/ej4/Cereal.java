package tp2.ej4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Cereal {
    private String nombre;
    private List<Mineral> mineralesNecesarios = new ArrayList<>();

    public Cereal(String nombre) {
        this.nombre = nombre;
    }

}
