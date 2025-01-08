package src;

import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;

    public synchronized void setPotencia(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        notify();
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            while (true) { 
                synchronized (this) {
                    while (potenciaActual == potenciaObjectiu) {
                        wait();
                        if (potenciaActual == 0 && potenciaObjectiu == 0) break;
                    }
                }

                if (potenciaActual < potenciaObjectiu) {

                    potenciaActual++;

                    if (potenciaActual == potenciaObjectiu) {
                        System.out.printf("%s: Fer res Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                    } else {
                        System.out.printf("%s: Incre. Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                    }
                } else if (potenciaActual > potenciaObjectiu) {

                    potenciaActual--;
                    
                    if (potenciaActual == potenciaObjectiu) {
                        System.out.printf("%s: Fer res Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                    } else {
                        System.out.printf("%s: Decre. Objectiu: %d Actual: %d\n", getName(), potenciaObjectiu, potenciaActual);
                    }
                }

                Thread.sleep(random.nextInt(2000));

                if (potenciaActual == 0 && potenciaObjectiu == 0) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
