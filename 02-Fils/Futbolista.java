import java.util.Random;

public class Futbolista extends Thread {
    private int ngols;
    private int ntirades;

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    public Futbolista() {
        setNgols(0);
        setNtirades(0);
    }

    public int getNgols() { return ngols; }
    public int getNtirades() { return ntirades; }

    public void setNgols(int ngols) { this.ngols = ngols; }
    public void setNtirades(int ntirades) { this.ntirades = ntirades; }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (random.nextFloat() <= PROBABILITAT) ngols++;
        }
    }
}