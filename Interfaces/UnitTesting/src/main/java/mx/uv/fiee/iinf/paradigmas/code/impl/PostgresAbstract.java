package mx.uv.fiee.iinf.paradigmas.code.impl;
import mx.uv.fiee.iinf.paradigmas.code.interfaces.IDataAccess;
import mx.uv.fiee.iinf.paradigmas.code.models.Student;
import java.util.ArrayList;
/**
 * Implementación concreta de IDataAccess para PostgreSQL.
 * 
 * Esta clase proporciona acceso REAL a una base de datos PostgreSQL.
 * Implementa la interfaz IDataAccess<Student> permitiendo ser inyectada
 * en cualquier clase que dependa de esa interfaz.
 * 
 * IMPORTANTE: Esta implementación está diseñada para ser usada en
 * aplicaciones reales, NO en pruebas unitarias. Para testing se
 * debe usar MockPostgres que no requiere conexión a BD real.
 * 
 * Responsabilidades:
 * - Manejar conexiones a PostgreSQL
 * - Ejecutar operaciones CRUD en la base de datos
 * - Convertir datos entre objetos Java y formato de BD
 */
public class PostgresAbstract implements IDataAccess<Student> {
    /**
     * Abre una conexión a la base de datos PostgreSQL.
     * 
     * En una implementación real esto realizaría:
     * - Crear conexión con DriverManager.getConnection()
     * - Autenticarse con usuario y contraseña
     * - Verificar que la BD está disponible
     * 
     * Actualmente solo imprime un mensaje de demostración.
     */
    @Override
    public void open() {
        System.out.println("Opening Postgress connection");
        // En producción: DriverManager.getConnection("jdbc:postgresql://...", user, password)
    }
    /**
     * Recupera una lista de estudiantes desde PostgreSQL.
     * 
     * Equivalente a ejecutar: SELECT * FROM estudiantes
     * 
     * En una implementación real:
     * - Preparar un Statement SQL
     * - Ejecutar la consulta
     * - Mapear ResultSet a objetos Student
     * - Retornar la lista
     * 
     * @return Lista de estudiantes desde la base de datos
     *         (vacía en esta demostración)
     */
    @Override
    public java.util.List<Student> getList() {
        System.out.println("Getting students list from Postgress");
        return new ArrayList<Student>();
        // En producción: ejecutar SELECT y mapear resultados
    }
    /**
     * Inserta un nuevo estudiante en PostgreSQL.
     * 
     * Equivalente a ejecutar: INSERT INTO estudiantes VALUES(...)
     * 
     * En una implementación real:
     * - Preparar un PreparedStatement INSERT
     * - Establecer parámetros (nombre, edad, etc.)
     * - Ejecutar la actualización
     * - Retornar ID generado si es necesario
     * 
     * @param element El estudiante a insertar en la base de datos
     */
    @Override
    public void add(Student element) {
        System.out.println("Adding student to Postgress");
        // En producción: ExecuteUpdate() con los datos del estudiante
    }
}
