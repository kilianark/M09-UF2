package res;

public class MainDemoFil {
    public static void main(String[] args) {
        Thread filActual = Thread.currentThread();

        System.out.println("MainDemoFil.main:");
        System.out.print("Prioritat -> " + filActual.getPriority() + ", ");
        System.out.println("Nom -> " + filActual.getName());
        System.out.println("toString() -> " + filActual.toString());
    }
}