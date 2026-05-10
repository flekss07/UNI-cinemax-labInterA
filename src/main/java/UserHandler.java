import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler {
    private LinkedList<User> userList = new LinkedList<>();

    /*Funzione x registrare l'utente*/
    public void addUser() {
        Scanner s= new Scanner(System.in);
        User newUser = new User();

        //da inserire gestione errore nel caso si eviti di inserire il campo
        System.out.println("Inserire Nome"); 
        String nome = s.nextLine();
        newUser.setNome(nome);

        System.out.println("Inserire Cognome"); 
        String cognome = s.nextLine();
        newUser.setCognome(cognome);

        System.out.println("Inserire Username");
        String username=s.nextLine();
        newUser.setUsername(username);

        System.out.println("Inserire indirizzo di residenza");
        String indirizzo=s.nextLine();
        newUser.setIndirizzo(indirizzo);

        //da inserire gestione della data
        System.out.println("inserire la data con formato gioni/mesi/anni");

        //inserimento del ruolo (permettere all'utente di darsi un ruolo?)
        

}
    /* funzione per controllare se l'utente esiste già*/
    public void checkUser(User user){
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {
                // to change into throw exception (non bloccante)
                System.err.println("Errore: Username già esistente.");
            }
        }
    }
    
}
