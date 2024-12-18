package res;

import java.util.Random;

public class Futbolista extends Thread {
    private int ngols;
    private int ntirades;

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    public Futbolista(String nom) {
        super(nom);

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

    public static void main(String[] args) {
        System.out.println("Inici dels xuts --------------------");

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];

        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", 
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"
        };

        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(noms[i]);
            jugadors[i].start();
        }

        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        for (Futbolista jugador : jugadors) {
            System.out.println(jugador.getName() + " -> " + jugador.getNgols() + " gols");
        }
    }
}