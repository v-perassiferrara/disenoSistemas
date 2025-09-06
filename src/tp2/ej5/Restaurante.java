package tp2.ej5;
import lombok.*;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Restaurante {
    private String nombre;
    private int indice;
    @Builder.Default
    private ArrayList<Sucursal> sucursales = new ArrayList<>();
    @Builder.Default
    private Plato[] platos = new Plato[20];

    public void agregarPlato(Plato plato) {
        if (indice < platos.length) {
            platos[indice] = plato;
            System.out.println("Plato " + plato.getNombre() + " agregado en " + this.nombre);
            indice++;
        } else {
            System.out.println("No se pueden agregar más platos, capacidad máxima alcanzada.");
        }

    }
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
        System.out.println("Sucursal en "+ sucursal.getDireccion() +" agregado a " + this.nombre);
    }
}
