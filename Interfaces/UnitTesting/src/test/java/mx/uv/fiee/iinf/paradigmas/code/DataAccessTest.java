package mx.uv.fiee.iinf.paradigmas.code;
import mx.uv.fiee.iinf.paradigmas.code.interfaces.IDataAccess;
import mx.uv.fiee.iinf.paradigmas.code.models.Student;
import mx.uv.fiee.iinf.paradigmas.code.services.StudentManagement;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Suite de pruebas unitarias para la gestión de acceso a datos.
 * 
 * Esta clase demuestra pruebas unitarias de StudentManagement usando un mock
 * en lugar de una base de datos real. Esto permite:
 * 1. Pruebas rápidas sin conexión a BD
 * 2. Pruebas independientes sin dependencias externas
 * 3. Control total sobre el comportamiento simulado
 * 
 * Patrón utilizado: AAA (Arrange-Act-Assert)
 * - Arrange: Preparar datos y objetos necesarios
 * - Act: Ejecutar la operación a probar
 * - Assert: Verificar que el resultado es el esperado
 * 
 * Framework: JUnit 5 (Jupiter)
 */
public class DataAccessTest {
    /**
     * Prueba que se puede obtener una lista no vacía de estudiantes.
     * 
     * Patrón AAA:
     * - Arrange: Crear StudentManagement con MockPostgres
     * - Act: Llamar a getStudents()
     * - Assert: Verificar que la lista no está vacía
     * 
     * Esta prueba valida que el mock retorna al menos un estudiante.
     */
    @Test
    public void getStudentList(){
        // Arrange: preparar el servicio con un mock
        var service = new StudentManagement (new MockPostgres());
        // Act: obtener la lista de estudiantes
        var result = service.getStudents();
        // Assert: verificar que el resultado no está vacío
        assertFalse(result.isEmpty());
    }
    /**
     * Prueba que se puede añadir un estudiante sin excepciones.
     * 
     * Patrón AAA:
     * - Arrange: Crear StudentManagement con MockPostgres
     * - Act: Intentar añadir un nuevo estudiante
     * - Assert: Verificar que NO se lanza una excepción
     * 
     * Esta prueba valida que un estudiante válido (no nulo) es aceptado.
     */
    @Test
    public void addStudent(){
        // Arrange: preparar el servicio y un estudiante
        var service = new StudentManagement (new MockPostgres());
        // Act y Assert: añadir estudiante sin esperar excepciones
        assertDoesNotThrow(() -> service.addStudent(new Student()));
    }
    /**
     * Prueba que se lanza IllegalArgumentException al añadir un estudiante nulo.
     * 
     * Patrón AAA:
     * - Arrange: Crear StudentManagement con MockPostgres
     * - Act: Intentar añadir null
     * - Assert: Verificar que se lanza IllegalArgumentException
     * 
     * Esta prueba valida que la validación de null funciona correctamente.
     */
    @Test
    public void throwException(){
        // Arrange: preparar el servicio
        var service = new StudentManagement (new MockPostgres());
        // Act y Assert: verificar que se lanza la excepción esperada
        assertThrows(IllegalArgumentException.class, () -> service.addStudent(null));
    }
}
/**
 * Mock de PostgreSQL para pruebas unitarias.
 * 
 * Esta clase implementa IDataAccess<Student> pero NO se conecta a
 * una base de datos real. Simula el comportamiento de PostgreSQL
 * permitiendo pruebas rápidas e independientes.
 * 
 * Ventajas del mock:
 * - No requiere servidor de BD
 * - Pruebas ejecutadas en milisegundos
 * - No hay dependencias externas
 * - Comportamiento predecible y controlado
 * 
 * Ideal para pruebas unitarias, NO para pruebas de integración.
 */
class MockPostgres implements IDataAccess<Student> {
    /**
     * Simula apertura de conexión (sin hacer nada real).
     * Solo imprime un mensaje de demostración.
     */
    @Override
    public void open() {
        System.out.println("mocking open a connection");
    }
    /**
     * Simula recuperación de estudiantes desde BD.
     * Retorna una lista con UN estudiante vacío.
     * 
     * Esto asegura que la lista NO está vacía, permitiendo
     * que la prueba getStudentList() pueda verificar assertFalse(isEmpty()).
     * 
     * @return Lista con un estudiante de ejemplo
     */
    @Override
    public List<Student> getList() {
        System.out.println("mocking read one record from db");
        return List.of(new Student());
    }
    /**
     * Simula inserción de estudiante en BD.
     * Solo imprime un mensaje, sin realizar ninguna operación real.
     * 
     * @param element El estudiante a simular como insertado
     */
    @Override
    public void add(Student element) {
        System.out.println("mocking add one record to db");
    }
}
