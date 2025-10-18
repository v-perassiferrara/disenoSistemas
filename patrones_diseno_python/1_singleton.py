class InstitutoEducativo:
    _instance = None

    # @classmethod: Usa 'cls' para modificar variables de la clase o proporcionar constructores alternativos.
    # cls referencia a la clase misma, del mismo modo que self referencia a una instancia
    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = InstitutoEducativo()
        return cls._instance

    # Un método regular (de instancia) usaría 'self' para operar sobre el estado de un objeto particular.
    # Un @staticmethod no usaría 'self' ni 'cls' y actuaría como una función anidada sin acceso al estado de la clase o instancia.

if __name__ == '__main__':
    i1 = InstitutoEducativo.get_instance()
    i2 = InstitutoEducativo.get_instance()


    print(i1 is i2)