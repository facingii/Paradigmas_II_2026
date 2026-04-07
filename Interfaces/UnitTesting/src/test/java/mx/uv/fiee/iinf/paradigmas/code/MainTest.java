package mx.uv.fiee.iinf.paradigmas.code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Suite de pruebas unitarias para la clase Utils.
 * 
 * Estas pruebas validan la funcionalidad de multiplicación de matrices
 * incluyendo casos normales y casos de error.
 * 
 * Esta clase demuestra el concepto de TDD (Test Driven Development),
 * donde las pruebas guían el desarrollo del código.
 * 
 * Patrón utilizado: AAA (Arrange-Act-Assert)
 * Framework: JUnit 5 (Jupiter)
 */
public class MainTest {
    /**
     * Prueba la multiplicación de dos matrices 2x2.
     * 
     * Caso de prueba:
     *   Matriz A:  [[2, 3], [1, 2]]
     *   Matriz B:  [[5, 5], [9, 2]]
     *   Esperado:  [[37, 16], [23, 9]]
     * 
     * Cálculo:
     * - Posición [0][0]: 2*5 + 3*9 = 10 + 27 = 37
     * - Posición [0][1]: 2*5 + 3*2 = 10 + 6 = 16
     * - Posición [1][0]: 1*5 + 2*9 = 5 + 18 = 23
     * - Posición [1][1]: 1*5 + 2*2 = 5 + 4 = 9
     * 
     * Patrón AAA:
     * - Arrange: Preparar dos matrices 2x2
     * - Act: Ejecutar matrixMultiplication
     * - Assert: Comparar resultado con matriz esperada
     */
    @Test
    void shouldMultiplyTwoByTwoMatrices() {
        // Arrange: Preparar datos de entrada
        int[][] matrixA = {{2, 3}, {1, 2}};
        int[][] matrixB = {{5, 5}, {9, 2}};
        int[][] expected = {{37, 16}, {23, 9}};
        // Act: Ejecutar la multiplicación
        int[][] result = Utils.matrixMultiplication(matrixA, matrixB);
        // Assert: Verificar que el resultado coincide con lo esperado
        assertArrayEquals(expected, result);
    }
    /**
     * Prueba la multiplicación de matrices 1x1 (caso especial).
     * 
     * Este es el caso mínimo de multiplicación matricial: una matriz
     * de un solo elemento multiplicada por otra matriz de un solo elemento.
     * 
     * Caso de prueba:
     *   Matriz A:  [[4]]
     *   Matriz B:  [[7]]
     *   Esperado:  [[28]]
     * 
     * Propósito: Validar que el algoritmo funciona correctamente incluso
     * con matrices triviales.
     * 
     * Patrón AAA:
     * - Arrange: Crear dos matrices 1x1
     * - Act: Ejecutar matrixMultiplication
     * - Assert: Verificar que 4 * 7 = 28
     */
    @Test
    void shouldMultiplySingleValueMatrices() {
        // Arrange: Matrices de un solo elemento
        int[][] matrixA = {{4}};
        int[][] matrixB = {{7}};
        int[][] expected = {{28}};
        // Act: Ejecutar la multiplicación
        int[][] result = Utils.matrixMultiplication(matrixA, matrixB);
        // Assert: Verificar el resultado
        assertArrayEquals(expected, result);
    }
    /**
     * Prueba que se lanza una excepción con matrices incompatibles.
     * 
     * Para que dos matrices se multipliquen:
     *   columnas(A) == filas(B)  Y  columnas(B) == filas(A)
     * 
     * Caso de prueba (INVÁLIDO):
     *   Matriz A:  [[1, 2, 3], [4, 5, 6]]  (2×3)
     *   Matriz B:  [[7, 8], [9, 10]]        (2×2)
     * 
     * Análisis:
     *   - A tiene 3 columnas, B tiene 2 filas  ✗ (3 ≠ 2)
     *   - B tiene 2 columnas, A tiene 2 filas  ✓ (2 = 2)
     *   
     * Como la primera condición falla, debe lanzarse IllegalArgumentException
     * 
     * Patrón AAA:
     * - Arrange: Crear dos matrices incompatibles
     * - Act: Intentar multiplicarlas
     * - Assert: Verificar que se lanza la excepción esperada
     */
    @Test
    void shouldThrowExceptionWhenMatricesAreNotCompatible() {
        // Arrange: Matrices con dimensiones incompatibles
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8}, {9, 10}};
        // Act y Assert: Verificar que se lanza IllegalArgumentException
        assertThrows(IllegalArgumentException.class,
                () -> Utils.matrixMultiplication(matrixA, matrixB));
    }
}
