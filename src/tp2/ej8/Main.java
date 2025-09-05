package tp2.ej8;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        TipoAvion tipoAvion1 = new TipoAvion(737,180,700000);
        TipoAvion tipoAvion2 = new TipoAvion(430,100,50000);

        Persona propietario = Persona.builder()
                .nombre("Juan Pérez")
                .numeroSeguridadSocial(11111111)
                .direccion("Av. Aeronáutica 123")
                .telefono(123456789)
                .build();

        Mecanico mecanico = Mecanico.builder()
                .nombre("Carlos Méndez")
                .numeroSeguridadSocial(22222222)
                .direccion("Calle Técnicos 456")
                .telefono(987654321)
                .turno("Diurno")
                .salario(50000)
                .build();

        Piloto piloto = Piloto.builder()
                .nombre("Ana López")
                .numeroSeguridadSocial(33333333)
                .direccion("Boulevard Aviación 789")
                .telefono(555555555)
                .numeroLicencia(12345)
                .restricciones("Lentes correctivos")
                .build();

        Hangar hangar = Hangar.builder()
                .numero(1)
                .capacidad(3)
                .ubicacion("Norte")
                .build();

        Avion avion1 = Avion.builder()
                .matricula(12345)
                .tipo(tipoAvion1)
                .fechaAdquisicion(new Date())
                .propietario(propietario)
                .build();

        Avion avion2 = Avion.builder()
                .matricula(67890)
                .tipo(tipoAvion2)
                .fechaAdquisicion(new Date())
                .propietario(propietario)
                .build();



        System.out.println("Hangar 1 = " + hangar);
        System.out.println(hangar.agregarAvion(avion1));
        System.out.println(hangar.agregarAvion(avion2));
        System.out.println("Capacidad hangar: " + hangar.getCapacidad());
        System.out.println();

        System.out.println(mecanico.agregarCertificacion(tipoAvion1));
        System.out.println(mecanico.agregarCertificacion(tipoAvion2));
        System.out.println("Mecánico certificado en: " + mecanico.getTiposAvionCertificados());
        System.out.println();

        System.out.println(piloto.agregarPermiso(tipoAvion1));
        System.out.println(piloto.agregarPermiso(tipoAvion2));
        System.out.println("Piloto autorizado para: " + piloto.getTiposAvionPermitidos());
        System.out.println();

        Date fechaHoy = new Date();

        Servicio servicio1 = Servicio.builder()
                .mecanico(mecanico)
                .avion(avion1)
                .fecha(fechaHoy)
                .duracionHoras(3)
                .tipo("Mantenimiento preventivo")
                .build();

        Servicio servicio2 = Servicio.builder()
                .mecanico(mecanico)
                .avion(avion1)
                .fecha(fechaHoy)                    // MISMA fecha
                .duracionHoras(5)                   // Diferente duración
                .tipo("Mantenimiento preventivo")   // MISMO tipo
                .build();

        Servicio servicio3 = Servicio.builder()
                .mecanico(mecanico)
                .avion(avion2)                      // DIFERENTE avión
                .fecha(fechaHoy)                    // MISMA fecha
                .duracionHoras(2)
                .tipo("Mantenimiento preventivo")   // MISMO tipo
                .build();

        Servicio servicio4 = Servicio.builder()
                .mecanico(mecanico)
                .avion(avion1)
                .fecha(new Date(System.currentTimeMillis() + 86400000)) // Día diferente
                .duracionHoras(4)
                .tipo("Reparación emergencia")      // DIFERENTE tipo
                .build();

        // 10. Registrar servicios - PRUEBA DE DUPLICADOS
        System.out.println("=== REGISTRO DE SERVICIOS ===");

        System.out.println("\n--- Servicio 1 (DEBE FUNCIONAR) ---");
        System.out.println(avion1.registrarServicio(servicio1));
        System.out.println(mecanico.registrarServicio(servicio1));

        System.out.println("\n--- Servicio 2 (DEBE FALLAR - DUPLICADO) ---");
        System.out.println(avion1.registrarServicio(servicio2));
        System.out.println(mecanico.registrarServicio(servicio2));

        System.out.println("\n--- Servicio 3 (DEBE FUNCIONAR - AVION DIFERENTE) ---");
        System.out.println(avion2.registrarServicio(servicio3));
        System.out.println(mecanico.registrarServicio(servicio3));

        System.out.println("\n--- Servicio 4 (DEBE FUNCIONAR - FECHA Y TIPO DIFERENTE) ---");
        System.out.println(avion1.registrarServicio(servicio4));
        System.out.println(mecanico.registrarServicio(servicio4));

        // 11. Mostrar resultados finales
        System.out.println("\n=== ESTADÍSTICAS FINALES ===");
        System.out.println("Servicios en avión 1: " + avion1.getServiciosRecibidos().size());
        System.out.println("Servicios en avión 2: " + avion2.getServiciosRecibidos().size());
        System.out.println("Total servicios realizados por mecánico: " + mecanico.getServiciosHechos().size());
        System.out.println("Aviones en hangar: " + hangar.getAviones().size());

        // 12. Probar que el mecánico puede trabajar en diferentes aviones
        System.out.println("\n=== VERIFICACIÓN DE CERTIFICACIONES ===");
        System.out.println("¿Puede el mecánico trabajar en Boeing 737? " +
                mecanico.getTiposAvionCertificados().contains(tipoAvion1));
        System.out.println("¿Puede el mecánico trabajar en Airbus 320? " +
                mecanico.getTiposAvionCertificados().contains(tipoAvion2));

        System.out.println("¿Puede el piloto volar Boeing 737? " +
                piloto.getTiposAvionPermitidos().contains(tipoAvion1));
        System.out.println("¿Puede el piloto volar Airbus 320? " +
                piloto.getTiposAvionPermitidos().contains(tipoAvion2));


    }
}