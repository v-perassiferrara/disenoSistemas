from abc import ABC, abstractmethod


class Persona(ABC):
    def __init__(self, nombre: str, dni: int) -> None:
        self._nombre = nombre
        self._dni = dni

    def identificate(self) -> str:
       frase = "Me identifico con: "
       frase += self._get_tipo_id()
       frase += ". El número es: "
       frase += self._get_identificacion()
       return frase

    @abstractmethod
    def _get_identificacion(self) -> str:
        pass

    @abstractmethod
    def _get_tipo_id(self) -> str:
        pass

    def get_nombre(self) -> str:
        return self._nombre


class Cliente(Persona):
    def __init__(self, numero_cliente: int, nombre: str, dni: int) -> None:
        self._numero_cliente = numero_cliente
        super().__init__(nombre, dni)

    def _get_identificacion(self) -> str:
        return str(self._numero_cliente)

    def _get_tipo_id(self) -> str:
        return "Número de cliente"

    def get_numero_cliente(self) -> int:
        return self._numero_cliente


class Empleado(Persona):
    def __init__(self, legajo: str, nombre: str, dni: int) -> None:
        self._legajo = legajo
        super().__init__(nombre, dni)

    def _get_identificacion(self) -> str:
        return str(self._legajo)

    def _get_tipo_id(self) -> str:
        return "Número de legajo"

    def get_legajo(self) -> str:
        return self._legajo

    def set_legajo(self, legajo: str) -> None:
        self._legajo = legajo


class Socio(Persona):
    def __init__(self, numero_socio: str, nombre: str, dni: int) -> None:
        self._numero_socio = numero_socio
        super().__init__(nombre, dni)

    def _get_identificacion(self) -> str:
        return str(self._numero_socio)

    def _get_tipo_id(self) -> str:
        return "Número de socio"

    def get_numero_socio(self) -> str:
        return self._numero_socio

    def set_numero_socio(self, numero_socio: str) -> None:
        self._numero_socio = numero_socio

def main():
    p = Cliente(1, "jorge", 21)
    print("cliente dice", p.identificate())

    e = Empleado(12, "ramon", 212)
    print("empleado dice", e.identificate())

    s = Socio(8, "carlos", 40)
    print("socio dice", s.identificate())

if __name__ == '__main__':
    main()