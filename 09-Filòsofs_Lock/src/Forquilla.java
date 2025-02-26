import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private final int num;
    private final Lock bloqueig = new ReentrantLock();

    public Forquilla(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean intentarAgafar() {
        return bloqueig.tryLock();
    }

    public void agafar(int filosof, String posicio) {
        bloqueig.lock();
        System.out.println("Fil" + filosof + " agafa la forquilla " + posicio + " " + num);
    }

    public void deixar(int filosof, String posicio) {
        System.out.println("Fil" + filosof + " deixa la forquilla " + posicio + " " + num);
        bloqueig.unlock();
    }
}
