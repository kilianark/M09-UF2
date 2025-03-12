import java.util.Random;

public class Barber extends Thread {

    private String nom;

    public Barber(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }

    @Override
    public void run() {
        synchronized (Barberia.instancia.condBarber) {
            while (true) {
                Client client = Barberia.instancia.seguentClient();
                if (client == null) {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + getNom() + " dormint");
                    try {
                        Barberia.instancia.condBarber.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Li toca al client " + client.getNom());
                    tallarCabell(client);
                }
            }
        }
    }

    private void tallarCabell(Client client) {
        try {
            System.out.println("Tallant cabell a " + client.getNom());
            Random rand = new Random();
            Thread.sleep(900 + rand.nextInt(100));  // 0.9s + random 0.1s
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}