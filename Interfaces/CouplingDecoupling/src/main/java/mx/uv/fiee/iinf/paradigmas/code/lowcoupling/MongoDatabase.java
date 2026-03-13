package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/** Implementación concreta: MongoDB — se intercambia sin tocar OrderService */
public class MongoDatabase implements Database {

    @Override
    public void connect() {
        System.out.println("[LowCoupling]  MongoDatabase : connecting to MongoDB...");
    }

    @Override
    public void save(String data) {
        System.out.println("[LowCoupling]  MongoDatabase : saving \"" + data + "\" into MongoDB.");
    }

    @Override
    public void disconnect() {
        System.out.println("[LowCoupling]  MongoDatabase : disconnecting from MongoDB.");
    }
}

