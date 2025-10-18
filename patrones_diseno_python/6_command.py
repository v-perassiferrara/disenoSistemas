from abc import ABC, abstractmethod

# Receptores/Servers (abstracto y concretos)

class IServer(ABC):
    @abstractmethod
    def apagate(self) -> None:
        pass

    @abstractmethod
    def prendete(self) -> None:
        pass

    @abstractmethod
    def conectate(self) -> None:
        pass

    @abstractmethod
    def verifica_conexion(self) -> None:
        pass

    @abstractmethod
    def guarda_log(self) -> None:
        pass

    @abstractmethod
    def cerra_conexion(self) -> None:
        pass

class ArgentinaServer(IServer):
    def apagate(self) -> None:
        print("Apagando Argentina")

    def prendete(self) -> None:
        print("Prendiendo Argentina")

    def conectate(self) -> None:
        print("Conectando Argentina")

    def verifica_conexion(self) -> None:
        print("Verificando conexion Argentina")

    def guarda_log(self) -> None:
        print("Guardando log Argentina")

    def cerra_conexion(self) -> None:
        print("Cerrando conexion Argentina")

class BrasilServer(IServer):
    def apagate(self) -> None:
        print("Apagando Brasil")

    def prendete(self) -> None:
        print("Prendiendo Brasil")

    def conectate(self) -> None:
        print("Conectando Brasil")

    def verifica_conexion(self) -> None:
        print("Verificando conexion Brasil")

    def guarda_log(self) -> None:
        print("Guardando log Brasil")

    def cerra_conexion(self) -> None:
        print("Cerrando conexion Brasil")

class USAServer(IServer):
    def apagate(self) -> None:
        print("Apagando USA")

    def prendete(self) -> None:
        print("Prendiendo USA")

    def conectate(self) -> None:
        print("Conectando USA")

    def verifica_conexion(self) -> None:
        print("Verificando conexion USA")

    def guarda_log(self) -> None:
        print("Guardando log USA")

    def cerra_conexion(self) -> None:
        print("Cerrando conexion USA")


# Comandos (abstracto y concretos)

class Command(ABC):
    @abstractmethod
    def execute(self) -> None:
        pass

class ApagarServer(Command):
    def __init__(self, servidor: IServer) -> None:
        self.servidor = servidor

    def execute(self) -> None:
        self.servidor.conectate()
        self.servidor.verifica_conexion()
        self.servidor.guarda_log()
        self.servidor.apagate()
        self.servidor.cerra_conexion()

class PrendeServer(Command):
    def __init__(self, servidor: IServer) -> None:
        self.servidor = servidor

    def execute(self) -> None:
        self.servidor.conectate()
        self.servidor.verifica_conexion()
        self.servidor.prendete()
        self.servidor.guarda_log()
        self.servidor.cerra_conexion()

class ResetServer(Command):
    def __init__(self, servidor: IServer) -> None:
        self.servidor = servidor

    def execute(self) -> None:
        self.servidor.conectate()
        self.servidor.verifica_conexion()
        self.servidor.guarda_log()
        self.servidor.apagate()
        self.servidor.prendete()
        self.servidor.guarda_log()
        self.servidor.cerra_conexion()


# Invocador para llamar a los comandos

class Invoker():
    def __init__(self, command: Command):
        self.command = command

    def run(self) -> None:
        self.command.execute()



# main

if __name__ == "__main__":
    command = PrendeServer(ArgentinaServer())
    command2 = PrendeServer(USAServer())
    serverAdmin = Invoker(command)
    serverAdmin.run()
    serverAdmin = Invoker(command2)
    serverAdmin.run()