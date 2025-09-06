package tp2.ej4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Lote {
    private Boolean esEspecial;
    private String cultivoPrevio;
    private List<Mineral> minerales = new ArrayList<>();

    public List<Mineral> getMinerales() {
        System.out.println("Estoy en minerales");
        System.out.println(minerales);
        return minerales;
    }


    public List<String> cerealesAconsejados(List<Cereal> cerealesDisponibles) {
        List<String> recomendados = new ArrayList<>();

        for (Cereal cereal : cerealesDisponibles) {
            // Revisar si el cereal es tp2.ej4.Pastura y hubo cultivo previo de pastura
            if (cereal instanceof Pastura && "tp2.ej4.Pastura".equals(this.cultivoPrevio)) {
                continue;
            }

            // Revisar si todos los minerales necesarios del cereal están presentes en el lote
            boolean cumpleMinerales = this.minerales.containsAll(cereal.getMineralesNecesarios());
            if (cumpleMinerales) {
                String ncereal = cereal.getNombre();
                recomendados.add(ncereal);
            }
        }

        return recomendados;
    }

    public void verificarSiEsEspecial () {
        for (Mineral mineral : this.minerales) {
            if (mineral.getIsPrimario()) { // si al menos uno es primario
                this.esEspecial = true;
                return;
            }
        }
        this.esEspecial = false; // si ninguno es primario
    }
}