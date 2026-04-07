package mx.uv.fiee.iinf.paradigmas.code.interfaces;
import java.util.List;
/**
 * Interfaz genérica que define el contrato para acceso a datos.
 * 
 * Implementa el Patrón Repository: abstrae los detalles específicos de
 * cómo se almacenan y recuperan los datos, permitiendo que el cliente
 * trabaje con una interfaz uniforme sin conocer la implementación.
 * 
 * Ventajas de usar esta interfaz:
 * 1. Cambiar la implementación sin modificar código cliente
 * 2. Facilita pruebas unitarias mediante mocks
 * 3. Desacoplamiento entre lógica de negocio y persistencia
 * 4. Sigue el Principio de Inversión de Dependencias (SOLID)
 * 
 * Tipo genérico T: Permite usar esta interfaz con cualquier tipo de objeto
 * Ejemplo: IDataAccess<Student>, IDataAccess<Usuario>, IDataAccess<Producto>
 * 
 * @param <T> El tipo de objeto que será gestionado por este acceso a datos
 */
public interface IDataAccess<T> {
    /**
     * Abre una conexión a la fuente de datos.
     * 
     * Esta operación debe preparar la conexión y los recursos necesarios
     * antes de realizar operaciones de lectura o escritura.
     * 
     * Implementaciones pueden conectarse a:
     * - Base de datos PostgreSQL, MySQL, etc.
     * - Archivos (CSV, JSON, XML)
     * - Servicios web REST
     * - Cache en memoria
     */
    void open();
    /**
     * Recupera una lista completa de todos los elementos almacenados.
     * 
     * Equivalente a un SELECT * en SQL.
     * 
     * @return List<T> contiene todos los elementos del tipo T almacenados
     *         Retorna una lista vacía si no hay elementos
     */
    List<T> getList();
    /**
     * Añade un nuevo elemento a la fuente de datos.
     * 
     * Equivalente a un INSERT en SQL.
     * 
     * @param element El elemento del tipo T a ser insertado
     *                No debe ser null (validación responsabilidad del cliente)
     */
    void add(T element);
}
