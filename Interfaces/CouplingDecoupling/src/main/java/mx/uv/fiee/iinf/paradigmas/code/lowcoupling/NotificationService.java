package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/**
 * BAJO ACOPLAMIENTO — Abstracción de notificaciones.
 * OrderService depende de este contrato, NO de email, SMS o push.
 */
public interface NotificationService {
    void send(String recipient, String message);
}

