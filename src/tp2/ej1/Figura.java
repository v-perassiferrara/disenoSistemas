package tp2.ej1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Figura {

    private String nombre;

    @Override
    public String toString() {
        return "Figura{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
