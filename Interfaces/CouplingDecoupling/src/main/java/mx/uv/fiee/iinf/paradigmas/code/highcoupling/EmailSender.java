package mx.uv.fiee.iinf.paradigmas.code.highcoupling;

/**
 * HIGHLY COUPLED — Servicio de notificación de pedidos.
 * Cableado directamente a EmailSender. Cambiar a SMS o notificaciones
 * Push requiere modificar esta clase directamente.
 */
public class EmailSender {

    public void sendEmail(String recipient, String message) {
        System.out.println("[HighCoupling] EmailSender: sending email to " + recipient
                + " → \"" + message + "\"");
    }
}

