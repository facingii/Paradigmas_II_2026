package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/** Implementación concreta: notificación por correo electrónico */
public class EmailNotification implements NotificationService {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[LowCoupling]  EmailNotification : sending email to "
                + recipient + " → \"" + message + "\"");
    }
}

