package mx.uv.fiee.iinf.paradigmas.code.services;
import mx.uv.fiee.iinf.paradigmas.code.interfaces.IDataAccess;
import mx.uv.fiee.iinf.paradigmas.code.models.Student;
import java.util.List;
/**
 * Servicio de gestión de estudiantes que implementa lógica de negocio.
 * 
 * Esta clase actúa como intermediaria entre la presentación y la capa de datos,
 * demostrando el patrón de Inyección de Dependencias. En lugar de crear
 * instancias directas de acceso a datos, recibe una implementación de IDataAccess
 * en el constructor, permitiendo cambiar la implementación sin modificar este código.
 * 
 * Responsabilidades:
 * - Validar datos antes de guardarlos
 * - Encapsular la lógica de negocio para estudiantes
 * - Delegar operaciones de persistencia a la implementación de IDataAccess
 * 
 * Ejemplo de uso:
 *   IDataAccess<Student> db = new PostgresAbstract(); // Inyectar dependencia
 *   StudentManagement service = new StudentManagement(db);
 *   service.addStudent(new Student());
 */
public class StudentManagement {
    /** Referencia a la implementación de acceso a datos. Final = no puede cambiar después de construcción */
    private final IDataAccess<Student> db;
    /**
     * Constructor que inyecta la dependencia de acceso a datos.
     * 
     * Este patrón permite:
     * 1. Usar diferentes implementaciones (PostgreSQL, Mock, archivo, etc.)
     * 2. Facilitar pruebas unitarias mediante mocks
     * 3. Cambiar la implementación sin modificar StudentManagement
     * 
     * @param db Una implementación de IDataAccess<Student> (puede ser real o mock)
     */
    public StudentManagement(IDataAccess<Student> db) {
        this.db = db;
    }
    /**
     * Añade un nuevo estudiante después de validarlo.
     * 
     * Proceso:
     * 1. Valida que el estudiante no sea null
     * 2. Si es válido, lo pasa a la capa de datos
     * 3. Imprime un mensaje de confirmación
     * 
     * @param student El estudiante a añadir
     * @throws IllegalArgumentException si el estudiante es null
     */
    public void addStudent(Student student) {
        validateStudent(student);
        db.add(student);
        System.out.println("Adding student " + student);
    }
    /**
     * Recupera la lista de todos los estudiantes.
     * 
     * Esta operación delega completamente a la implementación de IDataAccess.
     * 
     * @return List<Student> contiene todos los estudiantes almacenados
     *         Puede ser vacía si no hay estudiantes
     */
    public List<Student> getStudents() {
        System.out.println("Getting students");
        return db.getList();
    }
    /**
     * Valida que un estudiante sea válido (método privado).
     * 
     * Validaciones actuales:
     * - El estudiante no puede ser null
     * 
     * Futuros: se podrían añadir validaciones como:
     * - Nombre no vacío
     * - Edad dentro de rango válido
     * - Formato de datos correcto
     * 
     * @param student El estudiante a validar
     * @throws IllegalArgumentException con mensaje descriptivo si es inválido
     */
    private void validateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
    }
}
