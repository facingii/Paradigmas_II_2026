package mx.uv.fiee.iinf.paradigmas.code;

import mx.uv.fiee.iinf.paradigmas.code.models.Student;

import java.util.ArrayList;

public class ObjectBased {

    static void main() {
        // Lista basada en Object: pierde seguridad de tipos.
        var list = new ObjectList();
        list.add(new Student("Jennifer"));
        list.add(new Student("Michael"));
        list.add(8);

        // Casting manual al recuperar datos.
        var item1 = (Student) list.get(0);
        var item2 = (Student) list.get(1);
        var item3 = (Student) list.get(2);

        System.out.println(item1);
        System.out.println(item2);
    }

}

// Implementacion que acepta cualquier Object.
class ObjectList {

    ArrayList items = new ArrayList();

    public void add (Object item) {
        items.add(item);
    }

    public Object get (int index) {
        return items.get(index);
    }

}