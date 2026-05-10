import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler {
    private LinkedList<User> userList = new LinkedList<>();

    /*Funzione x registrare l'utente*/
    public void addUser() throws Exception{ 
        Scanner s= new Scanner(System.in);
        User newUser = new User();
        boolean x=true;

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


        
        //inserimento della password 
        while (x=true) {

        // da inserire un secondo inserimento della password per evitare errori di digitazione
        System.out.println("inserire una password");
        String password = s.nextLine();

        System.out.println("inserire nuovamente la password");
        String passcmp = s.nextLine();

        if(password==passcmp){}
            //encrypting della password
            AESencrypt crypted = new AESencrypt();
            newUser.setPassword(crypted.encrypt(password));

            x=false;
        }
    }
        

        

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
