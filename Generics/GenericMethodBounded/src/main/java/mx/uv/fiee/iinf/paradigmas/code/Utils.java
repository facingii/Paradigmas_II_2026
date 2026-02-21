package mx.uv.fiee.iinf.paradigmas.code;

import java.util.ArrayList;

/**
 * Clase de utilidades que proporciona métodos genéricos para operaciones
 * comunes con colecciones.
 *
 * Esta clase contiene métodos estáticos que aprovechan los parámetros de tipo
 * genéricos con límites (bounded type parameters) para implementar operaciones
 * seguras de tipo en tiempo de compilación.
 */
public class Utils {

    /**
     * Copia todos los elementos de una lista fuente a una lista destino.
     *
     * Este método genérico demuestra el uso de límites de comodín (wildcard bounds)
     * para asegurar que los elementos de la lista fuente puedan agregarse a la lista
     * destino. La lista fuente puede contener elementos de tipo T o subtipos de T
     * (varianza covariante), mientras que la lista destino puede contener elementos
     * de tipo T o supertipos de T (varianza contravariante).
     *
     * @param <T> el tipo genérico que actúa como límite superior para la lista fuente
     *            e inferior para la lista destino
     * @param source la lista fuente que contiene los elementos a copiar.
     *               Puede contener elementos de tipo T o subtipos de T
     * @param destination la lista destino donde se añadirán los elementos.
     *                    Puede almacenar elementos de tipo T o supertipos de T
     * @return la lista destino después de haber añadido todos los elementos
     *         de la lista fuente, castada al tipo {@code ArrayList<T>}
     *
     * @see java.util.ArrayList
     */
    public static <T> ArrayList<T> listCopy (ArrayList<? extends T> source, ArrayList<? super T> destination) {
        source.forEach (item -> {
            destination.add ((T) item);
        });

        return (ArrayList<T>) destination;
    }

}