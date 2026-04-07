package mx.uv.fiee.iinf.paradigmas.code;

import java.util.Iterator;

public class MyMarvelCollection implements Iterable<Film> {

    final private Film [] collection;

    public MyMarvelCollection(Film[] filmVector) {
        collection = filmVector;
    }

    public void add (Film film) {
        for (int i = 0; i < collection.length; i++) {
            if (collection [i] == null) {
                collection [i] = film;
                break;
            }
        }
    }

    public MyMarvelCollectionIterator iterator () {
        return new MyMarvelCollectionIterator();
    }


    class MyMarvelCollectionIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            return index < collection.length && collection[index] != null;
        }

        @Override
        public Object next() {
                return collection[index++];
                }
            }
}
