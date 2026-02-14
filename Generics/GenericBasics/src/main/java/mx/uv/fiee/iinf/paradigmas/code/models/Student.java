package mx.uv.fiee.iinf.paradigmas.code.models;

// Modelo de dominio basico para el ejemplo.
public class Student  {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Student name: %s", name);
    }
}