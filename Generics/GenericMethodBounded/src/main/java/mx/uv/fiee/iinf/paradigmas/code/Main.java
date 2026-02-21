package mx.uv.fiee.iinf.paradigmas.code;

import java.util.ArrayList;

/**
 * Clase principal que demuestra el uso de métodos genéricos con tipos acotados.
 *
 * Esta clase contiene el método de entrada al programa y proporciona un ejemplo
 * práctico de cómo utilizar el método genérico {@link Utils#listCopy(ArrayList, ArrayList)}
 * para copiar elementos de una lista a otra aplicando restricciones de tipos.
 *
 * El ejemplo crea una lista fuente de enteros, una lista destino de objetos,
 * y luego utiliza el método listCopy para copiar los elementos, especificando
 * que el tipo genérico es {@code Number}.
 */
public class Main {

    /**
     * Método de entrada del programa.
     * <p>
     * Crea dos listas: una fuente con valores enteros y una destino con valores
     * decimales. Posteriormente, invoca el método genérico listCopy para copiar
     * los elementos de la lista fuente a la lista destino, con el tipo genérico
     * especificado como {@code Number}. Finalmente, imprime todos los elementos
     * del resultado en la consola.
     *
     * @param args argumentos de la línea de comandos (no utilizados en este ejemplo)
     */
    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<>();
        source.add(10);
        source.add(20);
        source.add(30);
        source.add(40);
        source.add(50);

        ArrayList<Object> destination = new ArrayList<>();
        destination.add(10.10);
        destination.add(20.20);
        destination.add(30.30);

        ArrayList<Number> result = Utils.<Number>listCopy(source, destination);

        for (Object item : result) {
            System.out.println(item.toString());
        }
    }
}