import java.util.Random;

public class Assistent extends Thread {
    private final Esdeveniment esdeveniment;
    private final Random random = new Random();

    public Assistent(String nom, Esdeveniment esdeveniment) {
        super(nom);
        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
            if (random.nextBoolean()) esdeveniment.ferReserva(this);  
            else esdeveniment.cancelaReserva(this);

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
