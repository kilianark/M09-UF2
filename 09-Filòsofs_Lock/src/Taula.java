public class Taula {
    private final Filosof[] comensals;
    private final Forquilla[] forquilles;

    public Taula(int numFilosofs) {
        comensals = new Filosof[numFilosofs];
        forquilles = new Forquilla[numFilosofs];

        for (int i = 0; i < numFilosofs; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < numFilosofs; i++) {
            comensals[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % numFilosofs]);
        }
    }

    public void showTaula() {
        for (int i = 0; i < comensals.length; i++) {
            System.out.println("Comensal:Fil" + i + " esq:" + forquilles[i].getNum() + " dret:" + forquilles[(i + 1) % comensals.length].getNum());
        }
        System.out.println("-----------------------------");
    }

    public void cridarATaula() {
        for (Filosof filosof : comensals) {
            filosof.start();
        }
    }
}
