public class Forquilla {
    private int propietari;
    public static final int LLIURE = -1;

    public Forquilla() {
        this.propietari = LLIURE;
    }

    public synchronized void agafar(int filosof, String posicio) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = filosof;
        System.out.println("Filòsof: fil" + filosof + " agafa la forquilla " + posicio + " " + propietari);
    }

    public synchronized void deixar(int filosof, String posicio) {
        System.out.println("Filòsof: fil" + filosof + " deixa la forquilla " + posicio + " " + propietari);
        propietari = LLIURE;
        notifyAll();
    }
}