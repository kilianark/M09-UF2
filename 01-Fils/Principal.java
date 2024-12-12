public class Principal {
    public static void main(String[] args) {
        Fil filJuan = new Fil("Juan");
        Fil filPepe = new Fil("Pepe");

        filJuan.start();
        filPepe.start();

        System.out.println("Termina thread main");
    }
}