package tp2.ej3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad {

    private String nombre;
    private int habitantes;
    private boolean esCapital;
    private int gastoPublico;
    private Provincia provincia;
    @Builder.Default
    private List<Impuesto> impuestos = new ArrayList<>();



    public int calcularBalance() {

        int recaudacion = 0;

        for (Impuesto impuesto : impuestos) {
            recaudacion += impuesto.getValor();
        }

        return recaudacion - gastoPublico;
    }


    public void agregarImpuesto(Impuesto impuesto){

        this.impuestos.add(impuesto);

    }

}
