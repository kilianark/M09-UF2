
import java.util.Random;

public class Soci extends Thread {
    private static final float APORTACIO = 10.0f;
    private static final int MAX_ANYS = 10;
    private static final int ESPERA_MAX = 100;
    private final Random random = new Random();
    private final Compte compte;

    public Soci() {
        compte = Compte.getInstance();
    }

    @Override
    public void run() {
        for (int any = 0; any < MAX_ANYS; any++) {
            for (int mes = 0; mes < 12; mes++) {
                if (mes % 2 == 0) compte.ingressar(APORTACIO);
                else compte.retirar(APORTACIO);
                try {
                    Thread.sleep(random.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
