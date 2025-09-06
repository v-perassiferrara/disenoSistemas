package tp2.ej7;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estacion {
    private List<Pista> pistas;
    private int codigo;
    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private float kilometrosEsquiables;
    private int numPistas;
}