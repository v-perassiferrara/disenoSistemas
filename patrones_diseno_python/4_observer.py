from abc import ABC, abstractmethod

class Libro:
    def __init__(self, titulo:str = "", estado:str = "BUENO"):
        self._titulo = titulo
        self._estado = estado

    def get_titulo(self) -> str:
        return self._titulo

    def set_titulo(self, titulo:str) -> None:
        self._titulo = titulo

    def get_estado(self) -> str:
        return self._estado

    def set_estado(self, estado:str) -> None:
        self._estado = estado


# Interfaz a implementar para clases que quieran observar el cambio de estado
class ILibroMalEstado(ABC):
    @abstractmethod
    def update(self) -> None:
        pass

class Administrador(ILibroMalEstado):
    def update(self) -> None:
        print("Administración: Envio una queja formal...")

class Compras(ILibroMalEstado):
    def update(self) -> None:
        print("Compras: Solicito nueva cotizacion...")

class Stock(ILibroMalEstado):
    def update(self) -> None:
        print("Stock: Doy de baja...")


class Subject(ABC):
    @abstractmethod
    def attach(self, observer: ILibroMalEstado) -> None:
        pass

    @abstractmethod
    def detach(self, observer: ILibroMalEstado) -> None:
        pass

    @abstractmethod
    def notify_observers(self) -> None:
        pass

class AlarmaLibro(Subject):
    _observers: list[ILibroMalEstado] = []

    def attach(self, observer: ILibroMalEstado) -> None:
        self._observers.append(observer)

    def detach(self, observer: ILibroMalEstado) -> None:
        self._observers.remove(observer)

    def notify_observers(self) -> None:
        for observer in self._observers:
            observer.update()


class Biblioteca:
    @staticmethod
    def devuelve_libro(libro: Libro, alarma: AlarmaLibro):
        if libro.get_estado() == "MALO":
            alarma.notify_observers()


if __name__ == '__main__':
    alarma = AlarmaLibro()
    alarma.attach(Administrador())
    alarma.attach(Compras())
    alarma.attach(Stock())

    libro = Libro()
    libro.set_estado("MALO")

    biblioteca = Biblioteca()
    biblioteca.devuelve_libro(libro, alarma)