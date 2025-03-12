
import java.util.LinkedList;
import java.util.Random;

public class Estanc {

    private LinkedList<Tabac> tabac;
    private LinkedList<Paper> paper;
    private LinkedList<Llumi> llumins;
    private boolean obert;
    private final Random random;

    public Estanc() {
        this.tabac = new LinkedList<>();
        this.paper = new LinkedList<>();
        this.llumins = new LinkedList<>();
        this.obert = true;
        this.random = new Random();
    }

    public synchronized void nouSubministrament() {
        if (!obert) return;
        int opcio = random.nextInt(3);
        switch (opcio) {
            case 0 -> addTabac();
            case 1 -> addPaper();
            case 2 -> addLlumi();
        }
        notifyAll();
    }

    private synchronized void addTabac() {
        tabac.add(new Tabac());
        System.out.println("Afegint Tabac");
    }

    private synchronized void addPaper() {
        paper.add(new Paper());
        System.out.println("Afegint Paper");
    }

    private synchronized void addLlumi() {
        llumins.add(new Llumi());
        System.out.println("Afegint Llumí");
    }

    public synchronized Tabac venTabac() throws InterruptedException {
        while(obert && tabac.isEmpty()) wait();

        if(!obert) return null;
        return tabac.poll();
    }

    public synchronized Paper venPaper() throws InterruptedException {
        while(obert && paper.isEmpty()) wait();

        if(!obert) return null;
        return paper.poll();
    }

    public synchronized Llumi venLlumi() throws InterruptedException {
        while(obert && llumins.isEmpty()) wait();

        if(!obert) return null;
        return llumins.poll();
    }

    public synchronized void tancarEstanc() {
        obert = false;
        notifyAll();
        System.out.println("Estanc tancat");
    }

    public void executar() {
        System.out.println("Estanc obert");
        while (obert) {
            try {
                Thread.sleep(500 + random.nextInt(1000));
                nouSubministrament();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
