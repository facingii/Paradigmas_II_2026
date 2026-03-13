package mx.uv.fiee.iinf.paradigmas.code.highcoupling;

/**
 * HiGHLY COUPLED — OrderService
 *
 * Problemas:
 *  1. Instancia directamente MySQLDatabase  → atado a un solo motor de BD.
 *  2. Instancia directamente EmailSender    → atado a un solo canal de notificación.
 *  3. Para probar esta clase se necesita una BD real y un servicio de email real.
 *  4. Cualquier cambio en MySQLDatabase o EmailSender puede romper esta clase.
 */
public class OrderService {

    // ⚠️  Dependencias concretas creadas DENTRO de la clase — ¡highly coupled!
    private final MySQLDatabase database    = new MySQLDatabase();
    private final EmailSender   emailSender = new EmailSender();

    public void placeOrder(String product, String customerEmail) {
        System.out.println("\n[HighCoupling] OrderService: placing order for \"" + product + "\"");

        database.connect();
        database.save("ORDER: " + product);
        database.disconnect();

        emailSender.sendEmail(customerEmail, "Your order for \"" + product + "\" was placed!");
    }
}

