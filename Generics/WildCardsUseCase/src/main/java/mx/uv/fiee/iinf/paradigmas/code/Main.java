package mx.uv.fiee.iinf.paradigmas.code;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        /**
         * Lista fuente inicial, tipos enteros
         */
        ArrayList<Integer> source = new ArrayList<> ();
        source.add (10);
        source.add (20);
        source.add (30);
        source.add (40);
        source.add (50);

        /**
         * La lista destino está definida a tipos Object para poder almacenar cualquier otro tipo
         */
        ArrayList<Object> destiny = new ArrayList<> ();
        destiny.add (10.10);
        destiny.add (20.20);

        Utils.insertList (source, destiny); //invocamos al método genérico

        /**
         * la segunda lista fuente está definida a Strings
         */
        ArrayList<String> names = new ArrayList<> ();
        names.add ("John Snow");
        names.add ("Ned Stark");

        Utils.insertList (names, destiny); //invocamos al método genérico con las listas

        /**
         * la tercer lista está definida a tipos A
         */
        ArrayList<A> aaa = new ArrayList<> ();
        aaa.add (new A ());
        aaa.add (new A ());


        Utils.insertList (aaa, destiny);


        ArrayList<Number> sourceNumbers = new ArrayList<>();
        sourceNumbers.add(1.1);
        sourceNumbers.add(1);
        sourceNumbers.add(5.0f);

        ArrayList<Number> destinyNumbers = new ArrayList<>();
        Utils.insertList (sourceNumbers, destinyNumbers);

        /**
         * Para recorrer la lista destino debemos hacer uso de la clase base Object ya que aunque hayamos definido un límite inferior
         * el compilador no sabe qué tipos pueden ser leídos
         */
//        for (Object item: destiny) {
//            System.out.println (item);
//        }

        var ms = new MyStruct();
//        for (var i: ms)
//        {
//            //System.out.println("");
//        }

        String x = "hola";
        String y = "hola";

        System.out.println(y.compareTo(x));
    }
}

class A  {
    public String toString () {
        return "I'm an object of A class";
    }

}

class MyStruct implements Iterable<String>
{
    @Override
    public Iterator<String> iterator() {
        return null;
    }

}






