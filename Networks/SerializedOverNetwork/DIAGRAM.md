# SerializedOverNetwork — Diagrama de Funcionalidad

## Propósito del Proyecto

Este proyecto demuestra la **serialización de objetos Java y su transmisión a través de una red TCP**.  
Consiste en dos aplicaciones independientes:

- **Sender**: actúa como servidor TCP; genera objetos `Persona` con datos aleatorios, los serializa y los envía por el socket cada segundo.
- **Receiver**: actúa como cliente TCP; se conecta al servidor, recibe los bytes y los deserializa en objetos `Persona`, imprimiendo su UUID.

---

## Diagrama de Secuencia

```mermaid
sequenceDiagram
    participant S as Sender (Servidor :19000)
    participant R as Receiver (Cliente)

    Note over S: Crea ServerSocket<br/>en puerto 19000
    Note over S: Espera conexión entrante...

    R->>S: TCP connect() a localhost:19000
    Note over S: serverSocket.accept() ➜ Socket establecido

    loop Cada ~1 segundo (bucle infinito)
        Note over S: Genera Persona<br/>fullname = "Random Name X"<br/>age = aleatorio (0–54)<br/>uuid = UUID.randomUUID()
        Note over S: Serializa Persona con<br/>ObjectOutputStream → ByteArray
        S->>R: Envía bytes serializados por TCP
        Note over R: ObjectInputStream.readObject()<br/>↳ Deserializa → Persona
        Note over R: Imprime UUID recibido
    end

    Note over S,R: Fin de stream (EOFException) o error<br/>→ Receiver cierra el bucle
```

---

## Diagrama de Clases

```mermaid
classDiagram
    direction LR

    class Persona {
        -String fullname
        -int age
        -String uuid
        -long serialVersionUID = 1L
        +getFullname() String
        +setFullname(String) void
        +getAge() int
        +setAge(int) void
        +getUuid() String
        +setUuid(String) void
    }
    Persona ..|> Serializable : implements

    class Sender {
        -int PORT = 19000
        +main(String[]) void
    }
    class Sender_SocketUtils {
        -Socket socket
        +SocketUtils()
        +Send(byte[]) void
    }
    Sender --> Sender_SocketUtils : usa
    Sender --> Persona : crea y serializa

    class Receiver {
        +main(String[]) void
    }
    class Receiver_SocketUtils {
        -Socket socket
        +SocketUtils(String, int)
        +Receive() void
    }
    Receiver --> Receiver_SocketUtils : usa
    Receiver_SocketUtils --> Persona : deserializa
```

---

## Flujo de Datos

```mermaid
flowchart TD
    A([Inicio: Sender]) --> B[Crear ServerSocket\npuerto 19000]
    B --> C[Esperar conexión TCP]

    A2([Inicio: Receiver]) --> D[Crear Socket\nlocalhost:19000]
    D --> C

    C --> E[Conexión establecida]

    E --> F[Sender genera Persona\nfullname · age · uuid]
    F --> G[Serializar Persona\nObjectOutputStream → bytes]
    G --> H[Enviar bytes por TCP\nSocket.getOutputStream.write]
    H --> I[Receiver lee bytes\nObjectInputStream.readObject]
    I --> J[Deserializar → Persona]
    J --> K[Imprimir UUID recibido]
    K --> L{¿Fin de stream\no error?}
    L -- No --> F
    L -- Sí --> M([Fin: Receiver cierra])
```

