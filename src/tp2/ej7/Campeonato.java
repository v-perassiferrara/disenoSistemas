package tp2.ej7;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campeonato {
    private List<Prueba> pruebas;
    private List<Participante> participantes;
}