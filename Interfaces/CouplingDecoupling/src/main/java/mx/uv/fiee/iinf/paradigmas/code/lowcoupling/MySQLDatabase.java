package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/** Implementación concreta: MySQL */
public class MySQLDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("[LowCoupling]  MySQLDatabase : connecting to MySQL...");
    }

    @Override
    public void save(String data) {
        System.out.println("[LowCoupling]  MySQLDatabase : saving \"" + data + "\" into MySQL.");
    }

    @Override
    public void disconnect() {
        System.out.println("[LowCoupling]  MySQLDatabase : disconnecting from MySQL.");
    }
}

