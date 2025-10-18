# Aprobadores (abstracto y concretos)

from abc import ABC, abstractmethod
from typing import Optional


class IAprobador(ABC):
    @abstractmethod
    def set_next(self, aprobador: 'IAprobador') -> None:
        pass

    @abstractmethod
    def get_next(self) -> Optional['IAprobador']:   # Este optional es una medida de seguridad por si todavía no seteamos el next
        pass

    @abstractmethod
    def solicitud_prestamo(self,monto: int) -> None:
        pass


class EjecutivoDeCuenta(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self,monto: int) -> None:
        if monto <= 10000:
            print("Lo manejo yo, ejecutivo de cuentas")
        else:
            self.next.solicitud_prestamo(monto)

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


class LiderTeamEjecutivo(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self, monto: int) -> None:
        if 10000 < monto <= 50000:
            print("Lo manejo yo, líder")
        else:
            self.next.solicitud_prestamo(monto)

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


class Gerente(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self, monto: int) -> None:
        if 50000 < monto <= 100000:
            print("Lo manejo yo, gerente")
        else:
            self.next.solicitud_prestamo(monto)

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


class Director(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self, monto: int) -> None:
        if monto >= 100000:
            print("Lo manejo yo, director")
        else:
            self.next.solicitud_prestamo(monto)

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


# Main

if __name__ == "__main__":
    if __name__ == "__main__":
        ejecutivo = EjecutivoDeCuenta()
        lider = LiderTeamEjecutivo()
        gerente = Gerente()
        director = Director()

        ejecutivo.set_next(lider)
        lider.set_next(gerente)
        gerente.set_next(director)

        print("Préstamo de 5000")
        ejecutivo.solicitud_prestamo(5000)

        print("Préstamo de 50000")
        ejecutivo.solicitud_prestamo(50000)

        print("Préstamo de 500000")
        ejecutivo.solicitud_prestamo(500000)