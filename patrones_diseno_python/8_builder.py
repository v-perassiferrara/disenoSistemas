from abc import ABC, abstractmethod


# --- Producto y sus partes ---

class Motor:
    # El __init__ debe estar vacío para que el Builder
    # pueda asignar las partes una por una.
    def __init__(self) -> None:
        self.__numero = 0
        self.__potencia = ""

    def get_numero(self) -> int:
        return self.__numero

    def get_potencia(self) -> str:
        return self.__potencia

    def set_numero(self, numero) -> None:
        self.__numero = numero

    def set_potencia(self, potencia) -> None:
        self.__potencia = potencia

    # Añadido para imprimir mejor el resultado
    def __str__(self) -> str:
        return f"Motor(Potencia: {self.__potencia}, Nro: {self.__numero})"


class Auto:
    # Igual que Motor, __init__ vacío.
    def __init__(self):
        self.__cantidad_de_puertas = 0
        self.__modelo = ""
        self.__marca = ""
        self.__motor = None

    def get_cantidad_de_puertas(self) -> int:
        return self.__cantidad_de_puertas

    def get_modelo(self) -> str:
        return self.__modelo

    def get_marca(self) -> str:
        return self.__marca

    def get_motor(self) -> 'Motor':
        return self.__motor

    def set_cantidad_de_puertas(self, cantidad_de_puertas) -> None:
        self.__cantidad_de_puertas = cantidad_de_puertas

    def set_modelo(self, modelo) -> None:
        self.__modelo = modelo

    def set_marca(self, marca) -> None:
        self.__marca = marca

    def set_motor(self, motor) -> None:
        self.__motor = motor

    # Añadido para imprimir mejor el resultado
    def __str__(self) -> str:
        return (f"Auto(Marca: {self.__marca}, "
                f"Modelo: {self.__modelo}, "
                f"Puertas: {self.__cantidad_de_puertas}, "
                f"Motor: {self.__motor})")


# --- Builder Abstracto ---

class AutoBuilder(ABC):
    # El __init__ no recibe el auto, lo inicializa.
    def __init__(self):
        self._auto = None  # Se inicializa en None

    def get_auto(self) -> Auto:
        return self._auto

    # No es staticmethod. Es un método de instancia
    # que crea el objeto Auto (como en el Java )
    def crear_auto(self) -> None:
        self._auto = Auto()

    @abstractmethod
    def build_motor(self) -> None:
        pass

    @abstractmethod
    def build_modelo(self) -> None:
        pass

    @abstractmethod
    def build_marca(self) -> None:
        pass

    @abstractmethod
    def build_puertas(self) -> None:
        pass


# --- Builders Concretos ---

class FiatBuilder(AutoBuilder):
    # Se necesita el __init__ para llamar al padre
    def __init__(self):
        super().__init__()

    def build_marca(self) -> None:
        self._auto.set_marca("Fiat")

    def build_modelo(self) -> None:
        self._auto.set_modelo("Palio")

    def build_motor(self) -> None:
        # Instanciar Motor() con paréntesis
        motor = Motor()
        motor.set_numero(232323)
        motor.set_potencia("23 CV")
        self._auto.set_motor(motor)

    def build_puertas(self) -> None:
        self._auto.set_cantidad_de_puertas(4)


class FordBuilder(AutoBuilder):
    # Se necesita el __init__ para llamar al padre
    def __init__(self):
        super().__init__()

    def build_marca(self) -> None:
        self._auto.set_marca("Ford")

    def build_modelo(self) -> None:
        self._auto.set_modelo("Focus")

    def build_motor(self) -> None:
        # Instanciar Motor() con paréntesis
        motor = Motor()
        motor.set_numero(202020)
        motor.set_potencia("20 CV")
        self._auto.set_motor(motor)

    def build_puertas(self) -> None:
        self._auto.set_cantidad_de_puertas(2)


# --- Director ---

class AutoDirector:
    # __init__ no debe pedir el builder, para
    # poder asignarlo luego con set_auto_builder [cite: 183-185]
    def __init__(self) -> None:
        self.__auto_builder = None

    # El método se llama 'constructAuto' en el ejemplo
    # y no retorna nada, solo da las órdenes.
    def construir_auto(self) -> None:
        self.__auto_builder.crear_auto()
        self.__auto_builder.build_marca()
        self.__auto_builder.build_modelo()
        self.__auto_builder.build_motor()
        self.__auto_builder.build_puertas()

    def set_auto_builder(self, auto_builder: AutoBuilder) -> None:
        self.__auto_builder = auto_builder

    def get_auto(self) -> Auto:
        return self.__auto_builder.get_auto()


# --- Cliente (main) ---

if __name__ == "__main__":
    # Instanciar AutoDirector()
    director = AutoDirector()

    # Construir un Ford (como en el ejemplo de Java )
    print("Construyendo un Ford...")
    # Instanciar FordBuilder()
    director.set_auto_builder(FordBuilder())
    director.construir_auto()
    auto_ford = director.get_auto()

    # Imprimimos los resultados
    print(auto_ford)
    print(f"Marca: {auto_ford.get_marca()}")
    print(f"Modelo: {auto_ford.get_modelo()}")
    print("-" * 20)

    # Construir un Fiat
    print("Construyendo un Fiat...")
    # Instanciar FiatBuilder()
    director.set_auto_builder(FiatBuilder())
    director.construir_auto()
    auto_fiat = director.get_auto()

    print(auto_fiat)
    print(f"Marca: {auto_fiat.get_marca()}")
    print(f"Modelo: {auto_fiat.get_modelo()}")