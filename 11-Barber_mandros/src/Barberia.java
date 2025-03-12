import java.util.LinkedList;
import java.util.Queue;

public class Barberia extends Thread {
    
    private Queue<Client> salaEspera;
    private int numMaxCadires;
    public Object condBarber;
    public static Barberia instancia = null;

    public Barberia(int numMaxCadires) {
        this.numMaxCadires = numMaxCadires;
        this.salaEspera = new LinkedList<>();
        this.condBarber = new Object();
        instancia = this;
    }
    
    public synchronized Client seguentClient() { return salaEspera.poll(); }

    public synchronized void entrarClient(Client client) {
        if (salaEspera.size() < numMaxCadires) {
            salaEspera.add(client);
            System.out.println("Client " + client.getNom() + " en espera");
            synchronized (condBarber) {
                condBarber.notify();
            }
        } else {
            System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                Client client = new Client(i);
                entrarClient(client);
            }

            Thread.sleep(10000);

            for (int i = 11; i <= 20; i++) {
                Thread.sleep(500);
                Client client = new Client(i);
                entrarClient(client);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Barberia barberia = new Barberia(3);
        Barber barber = new Barber("Pepe");

        barber.start();
        barberia.start();

        barber.join();
        barberia.join();
    }
}
