class InstitutoEducativo:
    """
    Implementación Singleton correcta en Python,
    alineada con la intención teórica del patrón.
    """
    _instance = None

    '''
    @classmethod: Usa 'cls' para modificar variables de la clase o proporcionar constructores alternativos.
    cls referencia a la clase misma, del mismo modo que self referencia a una instancia
    Un método regular (de instancia) usaría 'self' para operar sobre el estado de un objeto particular.
    Un @staticmethod no usaría 'self' ni 'cls' y actuaría como una función anidada sin acceso al estado de la clase o instancia.
    '''

    def __new__(cls):
        """
        Sobrescribir __new__ es la forma de controlar la creación
        de instancias. Esto simula la lógica combinada del
        constructor privado y el método getInstance.
        """
        if cls._instance is None:
            # Si no existe, crea la instancia base
            print("Creando la única instancia de InstitutoEducativo...")
            cls._instance = super(InstitutoEducativo, cls).__new__(cls)

        # Siempre retorna la única instancia existente
        return cls._instance

    @classmethod
    def get_instance(cls):
        """
        Método de acceso global.
        En esta implementación, llamar a InstitutoEducativo()
        directamente o usar get_instance() da el mismo resultado.
        """
        return cls()  # Llama a __new__


if __name__ == '__main__':
    print("Iniciando prueba...")

    # Se intenta crear/obtener la instancia de varias formas
    i1 = InstitutoEducativo.get_instance()
    i2 = InstitutoEducativo()  # __new__ intercepta esto
    i3 = InstitutoEducativo.get_instance()

    print("\nResultados de la verificación:")
    # Se comprueba que todas las variables apunten al mismo objeto
    print(f"¿i1 es el mismo objeto que i2? {i1 is i2}")  # Debería ser True
    print(f"¿i1 es el mismo objeto que i3? {i1 is i3}")  # Debería ser True
    print(f"¿i2 es el mismo objeto que i3? {i2 is i3}")  # Debería ser True

    print("\nIdentificadores de memoria (deben ser iguales):")
    print(f"ID de i1: {id(i1)}")
    print(f"ID de i2: {id(i2)}")
    print(f"ID de i3: {id(i3)}")