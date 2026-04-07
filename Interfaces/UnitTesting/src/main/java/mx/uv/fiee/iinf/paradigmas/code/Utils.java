package mx.uv.fiee.iinf.paradigmas.code;
/**
 * Clase de utilidades que proporciona funciones matemáticas para operaciones matriciales.
 * 
 * Esta clase demuestra el concepto de TDD (Test Driven Development), donde las pruebas
 * unitarias guían el desarrollo del código. Todos los métodos son estáticos, permitiendo
 * su uso sin necesidad de crear instancias.
 * 
 * Funcionalidades:
 * - Multiplicación de matrices (O(n³) para matrices cuadradas)
 * - Validación de dimensiones para asegurar compatibilidad
 */
public class Utils {
    /**
     * Realiza la multiplicación de dos matrices.
     * 
     * Multiplicación matricial: Si A es una matriz m x n y B es n x p,
     * el resultado es una matriz m x p donde cada elemento es el producto
     * punto de la fila correspondiente de A con la columna de B.
     * 
     * @param matrixA Primera matriz a multiplicar (m x n)
     * @param matrixB Segunda matriz a multiplicar (n x p)
     * @return Matriz resultado de la multiplicación (m x p)
     * @throws IllegalArgumentException si las dimensiones no son compatibles
     *         (columnas de A debe ser igual a filas de B)
     */
    public static int[][] matrixMultiplication (int[][] matrixA, int[][] matrixB) {
        // Valida que las dimensiones sean compatibles
        VerifyBoundaries(matrixA, matrixB);
        // Crear la matriz resultado con dimensiones adecuadas
        int [][] result = new int [matrixA.length][matrixA[0].length];
        int sum = 0;
        // Iterar sobre filas de A y columnas de B
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB.length; j++) {
                // Calcular el producto punto (suma de productos)
                for (int k = 0; k < matrixA[i].length; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                // Guardar el resultado en la matriz
                result[i][j] = sum;
                sum = 0;
            }
        }
        return result;
    }
    /**
     * Valida que dos matrices sean compatibles para multiplicación.
     * 
     * Para que dos matrices puedan multiplicarse:
     * - Columnas de matrixA deben ser iguales a Filas de matrixB
     * - Columnas de matrixB deben ser iguales a Filas de matrixA
     * 
     * @param matrixA Primera matriz a validar
     * @param matrixB Segunda matriz a validar
     * @throws IllegalArgumentException si las matrices no son compatibles
     */
    public static void VerifyBoundaries(int[][] matrixA, int[][] matrixB) {
        // Obtener dimensiones de ambas matrices
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        // Primera condición: columnas de A = filas de B
        if (colsA != rowsB) {
            throw new IllegalArgumentException(
                String.format("Incompatibilidad: Columnas de A (%d) != Filas de B (%d)", colsA, rowsB)
            );
        }
        // Segunda condición: columnas de B = filas de A
        if (colsB != rowsA) {
            throw new IllegalArgumentException(
                String.format("Incompatibilidad: Columnas de B (%d) != Filas de A (%d)", colsB, rowsA)
            );
        }
    }
}
