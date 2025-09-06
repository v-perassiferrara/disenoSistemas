package tp2.ej4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)

public class Grano extends Cereal {
    private Boolean isGrueso;

    public Grano(String nombre, Boolean isGrueso) {
        super(nombre);
        this.isGrueso = isGrueso;
    }
}
