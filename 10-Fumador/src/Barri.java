public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
        for(int i = 0; i < 3; i++) fumadors[i] = new Fumador(estanc, i);
    }

    private void executar() throws InterruptedException {
        Thread estancThread = new Thread(estanc::executar);
        estancThread.start();

        for (Fumador f : fumadors) f.start();

        for (Fumador f : fumadors) f.join();

        estanc.tancarEstanc();
        estancThread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        Barri barri = new Barri();
        barri.executar();
    }
}
