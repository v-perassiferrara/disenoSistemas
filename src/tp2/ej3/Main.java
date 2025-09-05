package tp2.ej3;

public class Main {

    public static void main(String[] args) {

        Pais pais1 = Pais.builder()
                .nombre("Argentina")
                .build();

        Provincia prov1 = Provincia.builder()
                .nombre("Mendoza")
                .habitantes(3000000)
                .pais(pais1)
                .build();

        pais1.agregarProvincia(prov1);

        Ciudad ciudad1 = Ciudad.builder()
                .nombre("Mendoza")
                .habitantes(200000)
                .esCapital(true)
                .gastoPublico(30)
                .provincia(prov1)
                .build();

        Ciudad ciudad2 = Ciudad.builder()
                .nombre("Godoy Cruz")
                .habitantes(300000)
                .esCapital(false)
                .gastoPublico(80)
                .provincia(prov1)
                .build();

        Ciudad ciudad3 = Ciudad.builder()
                .nombre("Guaymallén")
                .habitantes(600000)
                .esCapital(false)
                .gastoPublico(200)
                .provincia(prov1)
                .build();

        prov1.agregarCiudad(ciudad1);
        prov1.agregarCiudad(ciudad2);
        prov1.agregarCiudad(ciudad3);

        Impuesto imp1 = new Impuesto("imp1",10);
        Impuesto imp2 = new Impuesto("imp2",20);
        Impuesto imp3 = new Impuesto("imp3",15);
        Impuesto imp4 = new Impuesto("imp4",8);
        Impuesto imp5 = new Impuesto("imp5",5);

        ciudad1.agregarImpuesto(imp1);
        ciudad1.agregarImpuesto(imp2);
        ciudad1.agregarImpuesto(imp3);
        ciudad1.agregarImpuesto(imp4);
        ciudad1.agregarImpuesto(imp5);

        ciudad2.agregarImpuesto(imp1);
        ciudad2.agregarImpuesto(imp2);
        ciudad2.agregarImpuesto(imp3);
        ciudad2.agregarImpuesto(imp4);
        ciudad2.agregarImpuesto(imp5);

        ciudad3.agregarImpuesto(imp1);
        ciudad3.agregarImpuesto(imp2);
        ciudad3.agregarImpuesto(imp3);
        ciudad3.agregarImpuesto(imp4);
        ciudad3.agregarImpuesto(imp5);

        System.out.println(ciudad1);
        System.out.println("Balance ciudad1: " + ciudad1.calcularBalance());

        System.out.println(ciudad2);
        System.out.println("Balance ciudad2: " + ciudad2.calcularBalance());

        System.out.println(ciudad3);
        System.out.println("Balance ciudad3: " + ciudad3.calcularBalance());

        System.out.println(prov1);
        System.out.println("El " + prov1.getPorcentajeCiudadesDeficit() + "% de ciudades tienen déficit.");

        Provincia prov2 = Provincia.builder()
                .nombre("San Juan")
                .habitantes(800000)
                .pais(pais1)
                .build();

        pais1.agregarProvincia(prov2);

        Ciudad ciudad4 = Ciudad.builder()
                .nombre("San Juan")
                .habitantes(400000)
                .esCapital(true)
                .gastoPublico(10)
                .provincia(prov2)
                .build();

        ciudad4.agregarImpuesto(imp1);
        ciudad4.agregarImpuesto(imp2);
        ciudad4.agregarImpuesto(imp3);
        ciudad4.agregarImpuesto(imp4);
        ciudad4.agregarImpuesto(imp5);

        prov2.agregarCiudad(ciudad4);

        System.out.println(prov2);
        System.out.println("El " + prov2.getPorcentajeCiudadesDeficit() + "% de ciudades tienen déficit.");

        System.out.println(pais1);
        System.out.println("Provincias con más de 50% de déficit (por ciudades):" + pais1.verificarGasto());
    }
}
