package src;

import java.util.Random;

public class DormAleatori extends Thread {
    private final long instantCreacio;

    public DormAleatori(String name) {
        super(name);
        this.instantCreacio = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int interval = random.nextInt(1000);
            long tempsTotal = System.currentTimeMillis() - instantCreacio;

            System.out.printf("%s(%d) a dormir %dms total %d\n", getName(), i, interval, tempsTotal);

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}
