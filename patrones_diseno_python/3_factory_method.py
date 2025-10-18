from abc import ABC, abstractmethod


class Triangulo(ABC):
    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        self._lado_a = lado_a
        self._lado_b = lado_b
        self._lado_c = lado_c

    @abstractmethod
    def get_descripcion(self) -> str:
        pass

    @abstractmethod
    def get_superficie(self) -> float:
        pass

    @abstractmethod
    def dibujate(self) -> None:
        pass

    def get_lado_a(self) -> int:
        return self._lado_a

    def get_lado_b(self) -> int:
        return self._lado_b

    def get_lado_c(self) -> int:
        return self._lado_c


class Equilatero(Triangulo):
    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Equilatero"

    def get_superficie(self) -> float:
        return 0

    def dibujate(self) -> None:
        pass


class Escaleno(Triangulo):
    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Escaleno"

    def get_superficie(self) -> float:
        return 1

    def dibujate(self) -> None:
        pass


class Isosceles(Triangulo):
    def __init__(self, lado_a: int, lado_b: int, lado_c: int):
        super().__init__(lado_a, lado_b, lado_c)

    def get_descripcion(self) -> str:
        return "Isosceles"

    def get_superficie(self) -> float:
        return 2

    def dibujate(self) -> None:
        pass




class TrianguloFactoryMethod(ABC):
    @staticmethod
    def create_triangulo(lado_a: int, lado_b: int, lado_c: int) -> Triangulo:
        pass

class TrianguloFactory(TrianguloFactoryMethod):
    @staticmethod
    def create_triangulo(lado_a: int, lado_b: int, lado_c: int) -> Triangulo:

        if lado_a == lado_b == lado_c:
            return Equilatero(lado_a, lado_b, lado_c)

        elif lado_a != lado_b != lado_c != lado_a:
            return Escaleno(lado_a, lado_b, lado_c)

        else:
            return Isosceles(lado_a, lado_b, lado_c)


if __name__ == "__main__":
    factory = TrianguloFactory()
    triangulo = factory.create_triangulo(10,10,10)
    print(triangulo.get_descripcion())