package mx.uv.fiee.iinf.paradigmas.code;

import mx.uv.fiee.iinf.paradigmas.code.models.Student;

import java.util.ArrayList;

public class NonGeneric {

    static void main() {
        // Demo simple: lista no generica con estudiantes.
        var studentList = new StudentList();
        studentList.add(new Student("Alice"));
        studentList.add(new Student("Bob"));

        // Al no usar genericos, el metodo get requiere casting interno.
        var student1 = studentList.get(0);
        var student2 = studentList.get(1);

        System.out.println(student1);
        System.out.println(student2);
    }

}

// Lista no generica: pierde seguridad de tipos y obliga a hacer casting.
class StudentList {

    ArrayList students = new ArrayList();

    public void add (Student student) {
        students.add(student);
    }

    public Student get (int index) {
        // Casting explicito: si el tipo almacenado no coincide, falla en runtime.
        return (Student) students.get(index);
    }
}
