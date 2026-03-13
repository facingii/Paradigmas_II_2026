package mx.uv.fiee.iinf.paradigmas.code.lowcoupling;

/** Implementación concreta: notificación por SMS — se intercambia sin tocar OrderService */
public class SmsNotification implements NotificationService {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[LowCoupling]  SmsNotification  : sending SMS to "
                + recipient + " → \"" + message + "\"");
    }
}

