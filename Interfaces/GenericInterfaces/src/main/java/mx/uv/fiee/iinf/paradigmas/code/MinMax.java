package mx.uv.fiee.iinf.paradigmas.code;

public class MinMax<T extends Comparable<T>> implements IMinMax<T> {

    T[] values;

    public MinMax (T[] values)
    {
        this.values = values;
    }

    public T min ()
    {
        T min = values[0];
        for (int i = 0; i < values.length; i++)
        {
            if (values[i].compareTo(min) < 0)
            {
                min = values[i];
            }
        }

        return min;
    }

    public T max ()
    {
        T max = values[0];
        for (int i = 0; i < values.length; i++)
        {
            if (values[i].compareTo(max) > 0)
            {
                max = values[i];
            }
        }

        return max;
    }

}
