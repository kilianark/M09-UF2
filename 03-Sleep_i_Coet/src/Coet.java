package src;

import java.util.Scanner;

public class Coet {
    private final Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
            motors[i].setName("Motor " + i);
        }
    }

    public void arranca() {
        for(Motor motor: motors) motor.start();
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("La potència ha d'estar entre 0 i 10.");
            return;
        }
        System.out.printf("Passant a potència %d\n", p);

        for (Motor motor: motors) motor.setPotencia(p);
    }

    public static void main(String[] args) {
        Coet coet = new Coet();

        coet.arranca();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) { 
                int potencia = scanner.nextInt();
                coet.passaAPotencia(potencia);

                if (potencia == 0) break;
            }
        }
    }
}
