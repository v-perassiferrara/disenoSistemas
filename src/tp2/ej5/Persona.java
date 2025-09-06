package tp2.ej5;
import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    private String nombre;
    private int indice = 0;
    @Builder.Default
    private ArrayList<Sucursal> sucursales = new ArrayList<>();
    @Builder.Default
    private ArrayList<Gusto> gustos = new ArrayList<>();

    public void frecuentaSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
        System.out.println("Persona "+ this.nombre +" frecuenta sucursal en " + sucursal.getDireccion());
    }

    public void leGusta(Plato plato, Sucursal sucursal) {
        Gusto gusto = new Gusto();
        // acá podrías setear datos en gusto con plato y sucursal
        gustos.add(gusto);
        System.out.println("Se agregó gusto" + indice);
        indice++;
    }
}
