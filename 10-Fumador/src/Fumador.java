import java.util.Random;

public class Fumador extends Thread {

    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Paper paper;
    private Llumi llumi;
    private int fumades = 0;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (fumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();

                if (tabac != null && paper != null && llumi != null) fumar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void compraTabac() throws InterruptedException {
        if (tabac == null) {
            tabac = estanc.venTabac();
            if (tabac != null) System.out.println("Fumador " + id + " comprant Tabac");
        }
    }

    private void compraPaper() throws InterruptedException {
        if(paper == null) {
            paper = estanc.venPaper();
            if (paper != null) System.out.println("Fumador " + id + " comprant Paper");
        }
    }

    private void compraLlumi() throws InterruptedException {
        if(llumi == null) {
            llumi = estanc.venLlumi();
            if(llumi != null) System.out.println("Fumador " + id + " comprant Llumí");
        }
    }

    private void fumar() throws InterruptedException {
        System.out.println("Fumador " + id + " fumant");
        Thread.sleep(500 + new Random().nextInt(500));
        fumades++;
        System.out.println("Fumador " + id + " ha fumat " + fumades + " vegades");
        tabac = null;
        paper = null;
        llumi = null;
    }

    
}
