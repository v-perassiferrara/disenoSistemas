from abc import ABC, abstractmethod

class Persona:
    def __init__(self, nombre: str = "", apellido: str = ""):
        self.__nombre = nombre
        self.__apellido = apellido

    def get_nombre(self) -> str:
        return self.__nombre

    def get_apellido(self) -> str:
        return self.__apellido

    def set_nombre(self, nombre: str) -> None:
        self.__nombre = nombre

    def set_apellido(self, apellido: str) -> None:
        self.__apellido = apellido


class Alumno(Persona):
    def __init__(self, nombre: str = "", apellido: str = "", promedio: float = 0.0):
        super().__init__(nombre, apellido)
        self.__promedio = promedio

    def get_promedio(self) -> float:
        return self.__promedio

    def set_promedio(self, promedio: float) -> None:
        self.__promedio = promedio


class Profesor(Persona):
    def __init__(self, nombre: str = "", apellido: str = "", legajo: str = ""):
        self.__legajo = legajo
        super().__init__(nombre, apellido)

    def get_legajo(self) -> str:
        return self.__legajo

    def set_legajo(self, legajo: str) -> None:
        self.__legajo = legajo


class Socio(Persona):
    def __init__(self, nombre: str = "", apellido: str = "", cuota: float = 0.0):
        self.__cuota = cuota
        super().__init__(nombre, apellido)

    def get_numero_socio(self) -> float:
        return self.__cuota

    def set_numero_socio(self, numero_socio: float) -> None:
        self.__cuota = numero_socio

class Libro:
    def __init__(self, titulo: str = "", estado: str = ""):
        self.__titulo = titulo
        self.__estado = estado

    def get_titulo(self) -> str:
        return self.__titulo

    def get_estado(self) -> str:
        return self.__estado

    def set_estado(self, estado: str) -> None:
        self.__estado = estado

    def set_titulo(self, titulo: str) -> None:
        self.__titulo = titulo



class Biblioteca:
    libros: list[Libro] = []

    def __init__(self, libros):
        libro = Libro()
        libro.set_estado("Bueno")
        libro.set_titulo("Algún titulo")

        libros.append(libro)

    @staticmethod
    def obtener_libros() -> list[Libro]:
        return Biblioteca.libros


class LibroStrategy(ABC):
    @abstractmethod
    def find_libro(self, titulo: str):
        pass

class BuenoNuevoRegularStrategy(LibroStrategy):
    def find_libro(self, titulo: str) -> Libro:
        libro = Libro()
        libro.set_estado("Bueno")
        return libro

class NuevoBuenoRegularStrategy(LibroStrategy):
    def find_libro(self, titulo: str) -> Libro:
        libro = Libro()
        libro.set_estado("Nuevo")
        return libro

class RegularBuenoNuevoStrategy(LibroStrategy):
    def find_libro(self, titulo: str) -> Libro:
        libro = Libro()
        libro.set_estado("Regular")
        return libro

class LibroFinder:
    @staticmethod
    def find_libro(persona: Persona, titulo: str) -> Libro:
        strategy = None

        if isinstance(persona, Socio):
            strategy = NuevoBuenoRegularStrategy()
        elif isinstance(persona, Profesor):
            strategy = BuenoNuevoRegularStrategy()
        else:
            strategy = RegularBuenoNuevoStrategy()

        return strategy.find_libro(titulo)


def main():
    socio = Socio()
    libro = LibroFinder.find_libro(socio,"Jorgito")
    print(libro.get_estado())


if __name__ == '__main__':
    main()