package mx.uv.fiee.iinf.paradigmas.code;

import mx.uv.fiee.iinf.paradigmas.code.models.Student;

import java.util.ArrayList;

public class GenericVersion  {

    static void main() {
        // Lista generica: fija el tipo en tiempo de compilacion.
        var list = new AnyList<Student>();
        list.add(new Student("Jennifer"));
        list.add(new Student("Michael"));

        // No se requiere casting: el tipo es seguro en tiempo de compilacion.
        var item1 = list.get(0);
        var item2 = list.get(1);

        System.out.println(item1);
        System.out.println(item2);

        var listN = new AnyList<Integer>();
        listN.add(10);
    }

}

class AnyList<T> {

    // Lista tipada con el parametro generico.
    ArrayList<T> items = new ArrayList<>();

    public void add (T item) {
        items.add(item);
    }

    public T get (int index) {
        return items.get(index);
    }
}
