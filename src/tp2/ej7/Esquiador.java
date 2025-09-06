package tp2.ej7;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Esquiador {
    private int dni;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private boolean federado;
}