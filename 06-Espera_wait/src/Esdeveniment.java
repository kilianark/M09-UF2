import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private final int maxPlaces;
    private final List<Assistent> reserves;

    public Esdeveniment(int maxPlaces) {
        this.maxPlaces = maxPlaces;
        this.reserves = new ArrayList<>();
    }

    public synchronized void ferReserva(Assistent assistent) {
        while (reserves.size() >= maxPlaces) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reserves.add(assistent);
        System.out.println(assistent.getName() + " ha fet una reserva. Places disponibles: " + (maxPlaces - reserves.size()));
        notifyAll();
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        if (reserves.remove(assistent)) {
            System.out.println(assistent.getName() + " ha cancel·lat una reserva. Places disponibles: " + (maxPlaces - reserves.size()));
            notifyAll();
        } else System.out.println(assistent.getName() + " no ha pogut cancel·lar una reserva inexistent. Places disponibles: " + (maxPlaces - reserves.size()));
    }
}
