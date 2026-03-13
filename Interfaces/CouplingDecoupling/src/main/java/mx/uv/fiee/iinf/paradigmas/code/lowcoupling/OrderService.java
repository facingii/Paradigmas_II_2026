package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/**
 * BAJO ACOPLAMIENTO — OrderService (Inyección de Dependencias)
 *
 * ✅ Depende únicamente de interfaces (Database, NotificationService).
 * ✅ Las implementaciones concretas se inyectan desde afuera (inyección por constructor).
 * ✅ Intercambiar MySQL → MongoDB o Email → SMS requiere CERO cambios aquí.
 * ✅ Fácil de probar con implementaciones mock/stub.
 */
public class OrderService {

    // ✅ Dependencias declaradas como interfaces — ¡bajo acoplamiento!
    private final Database             database;
    private final NotificationService  notificationService;

    /** Inyección de dependencias mediante constructor */
    public OrderService(Database database, NotificationService notificationService) {
        this.database            = database;
        this.notificationService = notificationService;
    }

    public void placeOrder(String product, String customerContact) {
        System.out.println("\n[LowCoupling]  OrderService: placing order for \"" + product + "\"");

        database.connect();
        database.save("ORDER: " + product);
        database.disconnect();

        notificationService.send(customerContact, "Your order for \"" + product + "\" was placed!");
    }
}

