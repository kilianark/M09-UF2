import java.util.Random;

public class Treballador extends Thread {
    private final int nouAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random rnd;

    public Treballador(String nom, int nouAnualBrut, int edatIniciTreball, int edatFiTreball) {
        super(nom);
        this.nouAnualBrut = nouAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    private void cobra() {
        cobrat += nouAnualBrut / 12.0f;
    }

    private void pagaImpostos() {
        cobrat -= (nouAnualBrut / 12.0f) * 0.24;
    }

    @Override
    public void run() {
        while (edatActual < edatFiTreball) {
            try {
                if (edatActual >= edatIniciTreball) {
                    for(int i = 1; i <= 12; i++){ 
                        cobra();
                        pagaImpostos();
                        Thread.sleep(rnd.nextInt(10));
                    }
                }
                edatActual++;
            } catch (InterruptedException e) {
                System.out.println(getName() + " ha estat interromput.");
                return;
            }
        }
    }

    public float getCobrat(){ return cobrat; }

    public int getEdat(){ return edatActual; }
}
