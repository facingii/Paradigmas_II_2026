package mx.uv.fiee.iinf.paradigmas.code.models;
/**
 * Clase modelo que representa la entidad Estudiante.
 * 
 * Esta es una clase POJO (Plain Old Java Object) simple que actúa como
 * contenedor de datos para información de estudiantes. Se utiliza en
 * conjunto con la interfaz IDataAccess para demostrar genéricos en Java.
 * 
 * Responsabilidades:
 * - Almacenar información básica del estudiante (nombre y edad)
 * - Proporcionar representación en texto para impresión
 * 
 * Nota: Los atributos son públicos para simplicidad en este ejemplo.
 * En producción, se recomienda usar encapsulación con getters/setters.
 */
public class Student {
    /** Nombre del estudiante */
    public String name;
    /** Edad del estudiante en años */
    public int age;
    /**
     * Retorna una representación en texto del estudiante.
     * 
     * Formato: Student [name=nombreDelEstudiante, age=edad]
     * 
     * Ejemplo de salida: Student [name=Bob Dylan, age=25]
     * 
     * @return String con la representación legible del estudiante
     */
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
