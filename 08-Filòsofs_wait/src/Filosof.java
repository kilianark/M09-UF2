import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra, dreta;
    private final Random random = new Random();
    private int gana = 0;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " pensant");
        Thread.sleep(1000 + random.nextInt(1001));
    }

    private void menjar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " menja");
        Thread.sleep(1000 + random.nextInt(1001));
        System.out.println("Filòsof: fil" + id + " ha acabat de menjar");
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            synchronized (esquerra) {
                esquerra.agafar(id, "esquerra");
                synchronized (dreta) {
                    if (dreta != null) {
                        dreta.agafar(id, "dreta");
                        return;
                    }
                }
                System.out.println("Filòsof: fil" + id + " deixa l'esquerra (" + id + ") i espera (dreta ocupada)");
                esquerra.deixar(id, "esquerra");
                gana++;
                System.out.println("Filòsof: fil" + id + " gana=" + gana);
                Thread.sleep(500 + random.nextInt(501));
            }
        }
    }

    private void deixarForquilles() {
        dreta.deixar(id, "dreta");
        esquerra.deixar(id, "esquerra");
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                agafarForquilles();
                menjar();
                deixarForquilles();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
