package mx.uv.fiee.iinf.paradigmas.code.highcoupling;

/**
 * ALTO ACOPLAMIENTO - Clase concreta de base de datos.
 * OrderService está directamente ligado a ESTA clase específica.
 * Cambiar el motor de base de datos obliga a modificar todos los lugares donde se usa.
 */
public class MySQLDatabase {

    public void connect() {
        System.out.println("[HighCoupling] MySQLDatabase: connecting to MySQL server...");
    }

    public void save(String data) {
        System.out.println("[HighCoupling] MySQLDatabase: saving \"" + data + "\" directly into MySQL.");
    }

    public void disconnect() {
        System.out.println("[HighCoupling] MySQLDatabase: disconnecting from MySQL server.");
    }
}

