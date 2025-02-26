import java.util.Random;

public class Filosof extends Thread {
    private final int id;
    private final Forquilla esquerra, dreta;
    private final Random random = new Random();
    private long iniciGana;
    private long fiGana;
    private int gana = 0;

    public Filosof(int id, Forquilla esquerra, Forquilla dreta) {
        this.id = id;
        this.esquerra = esquerra;
        this.dreta = dreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Fil" + id + " pensant");
        iniciGana = System.currentTimeMillis();
        Thread.sleep(1000 + random.nextInt(1001));
    }

    private void menjar() throws InterruptedException {
        fiGana = System.currentTimeMillis();
        gana = calcularGana();
        System.out.println("Fil" + id + " menja amb gana " + gana);
        Thread.sleep(1000 + random.nextInt(1001));
        System.out.println("Fil" + id + " ha acabat de menjar");
        resetGana();
    }

    private void agafarForquilles() throws InterruptedException {
        while (true) {
            agafarForquillaEsquerra();
            if (agafarForquillaDreta()) {
                break;
            } else {
                esquerra.deixar(id, "esquerra");
                gana++;
                Thread.sleep(500 + random.nextInt(501));
            }
        }
    }

    private void agafarForquillaEsquerra() {
        esquerra.agafar(id, "esquerra");
    }

    private boolean agafarForquillaDreta() {
        if (dreta.intentarAgafar()) {
            System.out.println("Fil" + id + " agafa la forquilla dreta " + dreta.getNum());
            return true;
        }
        return false;
    }

    private void deixarForquilles() {
        dreta.deixar(id, "dreta");
        esquerra.deixar(id, "esquerra");
    }

    private int calcularGana() {
        return (int) ((fiGana - iniciGana) / 1000);
    }

    private void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
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
