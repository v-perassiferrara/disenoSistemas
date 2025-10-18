from abc import ABC, abstractmethod
from typing import Optional


class IAprobador(ABC):
    @abstractmethod
    def set_next(self, aprobador: 'IAprobador') -> None:
        pass

    @abstractmethod
    def get_next(self) -> Optional['IAprobador']:
        pass

    @abstractmethod
    def solicitud_prestamo(self, monto: int) -> None:
        pass


class EjecutivoDeCuenta(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self, monto: int) -> None:
        if 0 < monto <= 10000:
            print("Lo manejo yo, ejecutivo de cuentas")
        elif self.next:  # Pasa al siguiente SOLO SI hay un siguiente
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
        elif self.next:  # Pasa al siguiente SOLO SI hay un siguiente
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
        elif self.next:  # Pasa al siguiente SOLO SI hay un siguiente
            self.next.solicitud_prestamo(monto)

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


class Director(IAprobador):
    def __init__(self) -> None:
        self.next: Optional[IAprobador] = None  # No tendrá sucesor

    def get_next(self) -> Optional['IAprobador']:
        return self.next

    def solicitud_prestamo(self, monto: int) -> None:
        if monto > 100000:
            print("Lo manejo yo, director")

        # VERSIÓN CORREGIDA:
        # Se elimina el 'else'. Si el director no lo maneja,
        # la cadena termina aquí de forma segura, igual que en el PDF.
        #
        # Una implementación más robusta incluso manejaría el 'else'
        # imprimiendo "Solicitud rechazada" o similar.

    def set_next(self, aprobador: 'IAprobador') -> None:
        self.next = aprobador


# Main

if __name__ == "__main__":
    ejecutivo = EjecutivoDeCuenta()
    lider = LiderTeamEjecutivo()
    gerente = Gerente()
    director = Director()

    # Se arma la cadena
    ejecutivo.set_next(lider)
    lider.set_next(gerente)
    gerente.set_next(director)

    print("--- Préstamo de 5000 ---")
    ejecutivo.solicitud_prestamo(5000)

    print("\n--- Préstamo de 45000 ---")
    ejecutivo.solicitud_prestamo(45000)

    print("\n--- Préstamo de 85000 ---")
    ejecutivo.solicitud_prestamo(85000)

    print("\n--- Préstamo de 500000 ---")
    ejecutivo.solicitud_prestamo(500000)

    print("\n--- Préstamo de -100 (Prueba de error) ---")
    ejecutivo.solicitud_prestamo(-100)  # Esto ahora no hará nada, en lugar de crashear