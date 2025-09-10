package tp2.ej8;

import tp2.ej8.repositorios.InMemoryRepository;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Inicializar repositorios
        InMemoryRepository<TipoAvion> tipoAvionRepository = new InMemoryRepository<>();
        InMemoryRepository<Persona> personaRepository = new InMemoryRepository<>();
        InMemoryRepository<Mecanico> mecanicoRepository = new InMemoryRepository<>();
        InMemoryRepository<Piloto> pilotoRepository = new InMemoryRepository<>();
        InMemoryRepository<Hangar> hangarRepository = new InMemoryRepository<>();
        InMemoryRepository<Avion> avionRepository = new InMemoryRepository<>();
        InMemoryRepository<Servicio> servicioRepository = new InMemoryRepository<>();

        System.out.println("=========== PROBAMOS EL SISTEMA DE AVIONES ===========");

        // Crear tipos de avión con IDs
        TipoAvion tipoAvion1 = TipoAvion.builder()
                .id(1L)
                .numeroModelo(737)
                .capacidad(180)
                .peso(700000)
                .build();

        TipoAvion tipoAvion2 = TipoAvion.builder()
                .id(2L)
                .numeroModelo(320)
                .capacidad(150)
                .peso(600000)
                .build();

        TipoAvion tipoAvion3 = TipoAvion.builder()
                .id(3L)
                .numeroModelo(430)
                .capacidad(100)
                .peso(50000)
                .build();

        // Guardar tipos de avión en repositorio
        tipoAvionRepository.save(tipoAvion1);
        tipoAvionRepository.save(tipoAvion2);
        tipoAvionRepository.save(tipoAvion3);

        // Crear propietarios con IDs
        Persona propietario1 = Persona.builder()
                .id(1L)
                .nombre("Juan Pérez")
                .numeroSeguridadSocial(11111111)
                .direccion("Av. Aeronáutica 123")
                .telefono(123456789)
                .build();

        Persona propietario2 = Persona.builder()
                .id(2L)
                .nombre("María González")
                .numeroSeguridadSocial(44444444)
                .direccion("Calle Aviación 456")
                .telefono(111222333)
                .build();

        // Guardar propietarios
        personaRepository.save(propietario1);
        personaRepository.save(propietario2);

        // Crear mecánicos con IDs
        Mecanico mecanico1 = Mecanico.builder()
                .id(1L)
                .nombre("Carlos Méndez")
                .numeroSeguridadSocial(22222222)
                .direccion("Calle Técnicos 456")
                .telefono(987654321)
                .turno("Diurno")
                .salario(50000)
                .tiposAvionCertificados(new HashSet<>())
                .serviciosHechos(new HashSet<>())
                .build();

        Mecanico mecanico2 = Mecanico.builder()
                .id(2L)
                .nombre("Roberto Silva")
                .numeroSeguridadSocial(55555555)
                .direccion("Boulevard Mantenimiento 789")
                .telefono(666777888)
                .turno("Nocturno")
                .salario(55000)
                .tiposAvionCertificados(new HashSet<>())
                .serviciosHechos(new HashSet<>())
                .build();

        // Guardar mecánicos
        mecanicoRepository.save(mecanico1);
        mecanicoRepository.save(mecanico2);

        // Crear pilotos con IDs
        Piloto piloto1 = Piloto.builder()
                .id(1L)
                .nombre("Ana López")
                .numeroSeguridadSocial(33333333)
                .direccion("Boulevard Aviación 789")
                .telefono(555555555)
                .numeroLicencia(12345)
                .restricciones("Lentes correctivos")
                .tiposAvionPermitidos(new HashSet<>())
                .build();

        Piloto piloto2 = Piloto.builder()
                .id(2L)
                .nombre("Diego Martínez")
                .numeroSeguridadSocial(66666666)
                .direccion("Avenida Vuelo 321")
                .telefono(999888777)
                .numeroLicencia(67890)
                .restricciones("Sin restricciones")
                .tiposAvionPermitidos(new HashSet<>())
                .build();

        // Guardar pilotos
        pilotoRepository.save(piloto1);
        pilotoRepository.save(piloto2);

        // Crear hangares con IDs
        Hangar hangar1 = Hangar.builder()
                .id(1L)
                .numero(1)
                .capacidad(3)
                .ubicacion("Norte")
                .aviones(new HashSet<>())
                .build();

        Hangar hangar2 = Hangar.builder()
                .id(2L)
                .numero(2)
                .capacidad(5)
                .ubicacion("Sur")
                .aviones(new HashSet<>())
                .build();

        // Guardar hangares
        hangarRepository.save(hangar1);
        hangarRepository.save(hangar2);

        // Crear aviones con IDs
        Avion avion1 = Avion.builder()
                .id(1L)
                .matricula(12345)
                .tipo(tipoAvion1)
                .fechaAdquisicion(new Date())
                .propietario(propietario1)
                .serviciosRecibidos(new HashSet<>())
                .build();

        Avion avion2 = Avion.builder()
                .id(2L)
                .matricula(67890)
                .tipo(tipoAvion2)
                .fechaAdquisicion(new Date())
                .propietario(propietario1)
                .serviciosRecibidos(new HashSet<>())
                .build();

        Avion avion3 = Avion.builder()
                .id(3L)
                .matricula(11111)
                .tipo(tipoAvion3)
                .fechaAdquisicion(new Date())
                .propietario(propietario2)
                .serviciosRecibidos(new HashSet<>())
                .build();

        // Guardar aviones
        avionRepository.save(avion1);
        avionRepository.save(avion2);
        avionRepository.save(avion3);

        // Asignar aviones a hangares
        System.out.println("=== ASIGNACIÓN DE AVIONES A HANGARES ===");
        System.out.println("Hangar 1 = " + hangar1);
        System.out.println(hangar1.agregarAvion(avion1));
        System.out.println(hangar1.agregarAvion(avion2));
        System.out.println("Capacidad hangar 1: " + hangar1.getCapacidad());
        System.out.println("Aviones en hangar 1: " + hangar1.getAviones().size());

        System.out.println(hangar2.agregarAvion(avion3));
        System.out.println("Aviones en hangar 2: " + hangar2.getAviones().size());

        // Actualizar hangares en repositorio
        hangarRepository.genericUpdate(1L, hangar1);
        hangarRepository.genericUpdate(2L, hangar2);

        System.out.println();

        // Agregar certificaciones a mecánicos
        System.out.println("=== CERTIFICACIONES DE MECÁNICOS ===");
        System.out.println(mecanico1.agregarCertificacion(tipoAvion1));
        System.out.println(mecanico1.agregarCertificacion(tipoAvion2));
        System.out.println("Mecánico 1 certificado en: " + mecanico1.getTiposAvionCertificados().size() + " tipos");

        System.out.println(mecanico2.agregarCertificacion(tipoAvion2));
        System.out.println(mecanico2.agregarCertificacion(tipoAvion3));
        System.out.println("Mecánico 2 certificado en: " + mecanico2.getTiposAvionCertificados().size() + " tipos");

        // Actualizar mecánicos en repositorio
        mecanicoRepository.genericUpdate(1L, mecanico1);
        mecanicoRepository.genericUpdate(2L, mecanico2);
        System.out.println();

        // Agregar permisos a pilotos
        System.out.println("=== PERMISOS DE PILOTOS ===");
        System.out.println(piloto1.agregarPermiso(tipoAvion1));
        System.out.println(piloto1.agregarPermiso(tipoAvion2));
        System.out.println("Piloto 1 autorizado para: " + piloto1.getTiposAvionPermitidos().size() + " tipos");

        System.out.println(piloto2.agregarPermiso(tipoAvion1));
        System.out.println(piloto2.agregarPermiso(tipoAvion3));
        System.out.println("Piloto 2 autorizado para: " + piloto2.getTiposAvionPermitidos().size() + " tipos");

        // Actualizar pilotos en repositorio
        pilotoRepository.genericUpdate(1L, piloto1);
        pilotoRepository.genericUpdate(2L, piloto2);
        System.out.println();

        // Crear servicios con IDs
        Date fechaHoy = new Date();

        Servicio servicio1 = Servicio.builder()
                .id(1L)
                .mecanico(mecanico1)
                .avion(avion1)
                .fecha(fechaHoy)
                .duracionHoras(3)
                .tipo("Mantenimiento preventivo")
                .build();

        Servicio servicio2 = Servicio.builder()
                .id(2L)
                .mecanico(mecanico1)
                .avion(avion1)
                .fecha(fechaHoy)
                .duracionHoras(5)
                .tipo("Mantenimiento preventivo")
                .build();

        Servicio servicio3 = Servicio.builder()
                .id(3L)
                .mecanico(mecanico1)
                .avion(avion2)
                .fecha(fechaHoy)
                .duracionHoras(2)
                .tipo("Mantenimiento preventivo")
                .build();

        Servicio servicio4 = Servicio.builder()
                .id(4L)
                .mecanico(mecanico2)
                .avion(avion3)
                .fecha(new Date(System.currentTimeMillis() + 86400000))
                .duracionHoras(4)
                .tipo("Reparación emergencia")
                .build();

        // Registrar servicios
        System.out.println("=== REGISTRO DE SERVICIOS ===");

        System.out.println("\n--- Servicio 1 (DEBE FUNCIONAR) ---");
        System.out.println(avion1.registrarServicio(servicio1));
        System.out.println(mecanico1.registrarServicio(servicio1));
        servicioRepository.save(servicio1);

        System.out.println("\n--- Servicio 2 (DEBE FALLAR - DUPLICADO) ---");
        System.out.println(avion1.registrarServicio(servicio2));
        System.out.println(mecanico1.registrarServicio(servicio2));
        if (avion1.getServiciosRecibidos().contains(servicio2)) {
            servicioRepository.save(servicio2);
        }

        System.out.println("\n--- Servicio 3 (DEBE FUNCIONAR - AVION DIFERENTE) ---");
        System.out.println(avion2.registrarServicio(servicio3));
        System.out.println(mecanico1.registrarServicio(servicio3));
        servicioRepository.save(servicio3);

        System.out.println("\n--- Servicio 4 (DEBE FUNCIONAR - FECHA Y TIPO DIFERENTE) ---");
        System.out.println(avion3.registrarServicio(servicio4));
        System.out.println(mecanico2.registrarServicio(servicio4));
        servicioRepository.save(servicio4);

        // Actualizar entidades modificadas
        avionRepository.genericUpdate(1L, avion1);
        avionRepository.genericUpdate(2L, avion2);
        avionRepository.genericUpdate(3L, avion3);
        mecanicoRepository.genericUpdate(1L, mecanico1);
        mecanicoRepository.genericUpdate(2L, mecanico2);

        System.out.println("\n=== CONSULTAS USANDO REPOSITORIOS ===");

        // Buscar por ID
        System.out.println("\n--- Búsqueda por ID ---");
        Optional<Avion> avionEncontrado = avionRepository.findById(1L);
        avionEncontrado.ifPresent(a -> System.out.println("Avión encontrado por ID 1: " + a.getMatricula()));

        Optional<Mecanico> mecanicoEncontrado = mecanicoRepository.findById(2L);
        mecanicoEncontrado.ifPresent(m -> System.out.println("Mecánico encontrado por ID 2: " + m.getNombre()));

        // Buscar por campo
        System.out.println("\n--- Búsqueda por campo ---");
        List<TipoAvion> tiposPorModelo = tipoAvionRepository.genericFindByField("numeroModelo", 737);
        System.out.println("Tipos de avión con modelo 737: " + tiposPorModelo.size());

        List<Piloto> pilotosPorNombre = pilotoRepository.genericFindByField("nombre", "Ana López");
        System.out.println("Pilotos con nombre 'Ana López': " + pilotosPorNombre.size());

        // Mostrar estadísticas finales usando repositorios
        System.out.println("\n=== ESTADÍSTICAS FINALES ===");
        System.out.println("Total tipos de avión: " + tipoAvionRepository.findAll().size());
        System.out.println("Total propietarios: " + personaRepository.findAll().size());
        System.out.println("Total mecánicos: " + mecanicoRepository.findAll().size());
        System.out.println("Total pilotos: " + pilotoRepository.findAll().size());
        System.out.println("Total hangares: " + hangarRepository.findAll().size());
        System.out.println("Total aviones: " + avionRepository.findAll().size());
        System.out.println("Total servicios: " + servicioRepository.findAll().size());

        System.out.println("\n--- Servicios por avión ---");
        avionRepository.findAll().forEach(avion ->
                System.out.println("Avión " + avion.getMatricula() + ": " +
                        avion.getServiciosRecibidos().size() + " servicios"));

        System.out.println("\n--- Servicios por mecánico ---");
        mecanicoRepository.findAll().forEach(mecanico ->
                System.out.println("Mecánico " + mecanico.getNombre() + ": " +
                        mecanico.getServiciosHechos().size() + " servicios"));

        // Verificación de certificaciones
        System.out.println("\n=== VERIFICACIÓN DE CERTIFICACIONES ===");
        mecanicoRepository.findAll().forEach(mecanico -> {
            System.out.println("Mecánico " + mecanico.getNombre() + " certificado en " +
                    mecanico.getTiposAvionCertificados().size() + " tipos de avión");
        });

        pilotoRepository.findAll().forEach(piloto -> {
            System.out.println("Piloto " + piloto.getNombre() + " autorizado para " +
                    piloto.getTiposAvionPermitidos().size() + " tipos de avión");
        });

        System.out.println("\n=== PRUEBA DE ACTUALIZACIÓN ===");

        // Actualizar un avión
        Avion avionActualizado = Avion.builder()
                .id(1L)
                .matricula(99999) // Nueva matrícula
                .tipo(tipoAvion1)
                .fechaAdquisicion(avion1.getFechaAdquisicion())
                .propietario(propietario2) // Nuevo propietario
                .serviciosRecibidos(avion1.getServiciosRecibidos())
                .build();

        avionRepository.genericUpdate(1L, avionActualizado);
        Optional<Avion> avionVerificado = avionRepository.findById(1L);
        avionVerificado.ifPresent(a -> System.out.println("Avión actualizado - Nueva matrícula: " +
                a.getMatricula() + ", Nuevo propietario: " + a.getPropietario().getNombre()));

        System.out.println("\n=== PRUEBA DE ELIMINACIÓN ===");

        // Eliminar un servicio
        servicioRepository.genericDelete(2L);
        Optional<Servicio> servicioEliminado = servicioRepository.findById(2L);
        if (servicioEliminado.isEmpty()) {
            System.out.println("El servicio con ID 2 ha sido eliminado del repositorio.");
        }

        System.out.println("Total servicios después de eliminación: " + servicioRepository.findAll().size());

        System.out.println("\n=========== FIN DE PRUEBAS ===========");
    }
}