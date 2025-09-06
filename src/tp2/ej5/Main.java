package tp2.ej5;

public class Main {

    public static void main(String[] args) {
        Restaurante restaurante = Restaurante.builder()
                .nombre("Capri")
                .build();
        Plato plato1 = new Plato("Pizza");
        Plato plato2 = new Plato("Hamburguesa");
        Sucursal sucursal1 = new Sucursal("Aristides 123");
        Sucursal sucursal2 = new Sucursal("BSurMer 123");


        restaurante.agregarPlato(plato1);
        restaurante.agregarPlato(plato2);
        restaurante.agregarSucursal(sucursal1);
        restaurante.agregarSucursal(sucursal2);

        Persona per1 = Persona.builder()
                .nombre("Juanca")
                .build();
        Persona per2 = Persona.builder()
                .nombre("Seba")
                .build();

        per1.frecuentaSucursal(sucursal1);
        per2.frecuentaSucursal(sucursal2);

        per1.leGusta(plato1,sucursal1);

    }
}