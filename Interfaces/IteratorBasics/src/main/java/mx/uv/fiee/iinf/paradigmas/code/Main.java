package mx.uv.fiee.iinf.paradigmas.code;

public class Main {
    static void main() {

        var myCol = new MyMarvelCollection (filmVector);
        myCol.add (new Film ("Ironman", 2008));
        myCol.add (new Film ("Captain America", 2010));
        myCol.add (new Film ("The Avengers", 2012));

        var iterator = myCol.iterator ();
        while (iterator.hasNext ()) {
            System.out.println (iterator.next ());
        }

        for (var film: myCol) {
            System.out.println (film);
        }

    }
}
