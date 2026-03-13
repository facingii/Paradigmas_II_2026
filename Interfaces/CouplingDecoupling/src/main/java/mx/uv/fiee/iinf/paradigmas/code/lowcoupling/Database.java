package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/**
 * LOW COUPLED — Abstracción de base de datos.
 * OrderService depende de este contrato, NO de ningún motor concreto.
 */
public interface Database {
    void connect();
    void save(String data);
    void disconnect();
}

