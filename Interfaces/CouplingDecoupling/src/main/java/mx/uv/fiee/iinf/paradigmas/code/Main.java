package mx.uv.fiee.iinf.paradigmas.code;

import mx.uv.fiee.iinf.paradigmas.code.lowcoupling.EmailNotification;
import mx.uv.fiee.iinf.paradigmas.code.lowcoupling.MongoDatabase;
import mx.uv.fiee.iinf.paradigmas.code.lowcoupling.MySQLDatabase;
import mx.uv.fiee.iinf.paradigmas.code.lowcoupling.SmsNotification;

public class Main {

    void main() {
        //************************ HIGHLY COUPLED *******************************

        mx.uv.fiee.iinf.paradigmas.code.highcoupling.OrderService highCoupledService =
                new mx.uv.fiee.iinf.paradigmas.code.highcoupling.OrderService();

        highCoupledService.placeOrder("Laptop",  "alice@example.com");
        highCoupledService.placeOrder("Monitor", "bob@example.com");

        //************************ LOW COUPLED *******************************

        // MySQL + Email ─────────────────────────────────────
        System.out.println("\n--- Escenario A: MySQL + Email ---");
        mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService serviceA =
                new mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService(
                        new MySQLDatabase(),
                        new EmailNotification());
        serviceA.placeOrder("Keyboard", "carol@example.com");

        // MongoDB + SMS ─────────────────────────────────────
        System.out.println("\n--- Escenario B: MongoDB + SMS ---");
        mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService serviceB =
                new mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService(
                        new MongoDatabase(),
                        new SmsNotification());
        serviceB.placeOrder("Mouse", "+1-555-0199");

        // MongoDB + Email ─────────────────────────
        System.out.println("\n--- Escenario C: MongoDB + Email (mezcla) ---");
        mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService serviceC =
                new mx.uv.fiee.iinf.paradigmas.code.lowcoupling.OrderService(
                        new MongoDatabase(),
                        new EmailNotification());
        serviceC.placeOrder("Headset", "dave@example.com");
    }
}
