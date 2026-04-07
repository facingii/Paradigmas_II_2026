package mx.uv.fiee.iinf.paradigmas.code;
import mx.uv.fiee.iinf.paradigmas.code.impl.PostgresAbstract;
import mx.uv.fiee.iinf.paradigmas.code.models.Student;
import mx.uv.fiee.iinf.paradigmas.code.services.StudentManagement;
/**
 * Clase principal de la aplicacion que demuestra dos conceptos fundamentales:
 * 1. Multiplicacion de matrices (operacion matematica)
 * 2. Inyeccion de dependencias con interfaz genérica (patrón de diseño)
 *
 * Esta clase realiza demostraciones de ambas operaciones:
 * - Multiplica dos matrices 2x2 usando la clase Utils
 * - Crea un servicio de gestión de estudiantes con una dependencia inyectada
 *
 * NOTA: Esta demostración utiliza la base de datos real (PostgresAbstract),
 * lo cual NO es una buena práctica para pruebas unitarias. Para testing
 * se deben utilizar mocks (como MockPostgres en DataAccessTest).
 */
public class Main {
    /**
     * Método principal que demuestra:
     * 1. Multiplicación de matrices usando métodos estáticos de Utils
     * 2. Inyección de dependencias de la interfaz IDataAccess
     * 3. Gestión de estudiantes con una base de datos inyectada
     */
    static void main() {
        // ============ DEMOSTRACION 1: Multiplicacion de Matrices ============
        // Definir dos matrices 2x2
        int [][] matrixA = { {2, 3}, {1, 2} };
        int [][] matrixB = { {5, 5}, {9, 2} };
        // Multiplica las matrices
        var result = Utils.matrixMultiplication(matrixA, matrixB);
        // Imprime el resultado en formato fila-columna
        System.out.println("Resultado de multiplicacion matricial:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        // ============ DEMOSTRACION 2: Inyeccion de Dependencias ============
        // PostgresAbstract es una dependencia que será inyectada
        var postgres = new PostgresAbstract();
        // StudentManagement recibe la dependencia en el constructor
        // Esto permite cambiar la implementación sin modificar StudentManagement
        var management = new StudentManagement(postgres);
        // Crear un estudiante de ejemplo
        var student = new Student();
        student.name = "Bob Dylan";
        student.age = 25;
        // Realizar operaciones usando el servicio inyectado
        // ADVERTENCIA: Estas operaciones conectan a una base de datos real,
        // lo cual no es recomendable para pruebas automatizadas
        management.addStudent(student);
        management.getStudents().forEach(System.out::println);
    }
}
