public class Client {
    
    private String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public String getNom() { return nom; }
}
