import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler {
    private final LinkedList<User> userList = new LinkedList<>();
    /*Funzione x registrare l'utente*/
    public void addUser() throws Exception{
        Scanner s= new Scanner(System.in);
        User newUser = new User();
        //ruolo
        System.out.println("scegliere il ruolo");
        //Inserimento nome
        System.out.println("Inserire Nome");
        newUser.setNome(this.stringCheck());
       //inserimento cognome
        System.out.println("Inserire Cognome");
        newUser.setCognome(this.stringCheck());
        //inserimento username
        System.out.println("Inserire Username");
        newUser.setUsername(this.stringCheck());
        System.out.println("Inserire indirizzo di residenza");
        newUser.setIndirizzo(this.stringCheck());
        //da inserire gestione della data
        System.out.println("inserire la data con formato gioni/mesi/anni");
        //inserimento della password
        System.out.println("inserire una password");
        String password = this.passencryption();
        this.
    }

    private String passencryption()throws Exception{
        System.out.println("inserire una password");
            String password = this.stringCheck();
            System.out.println("inserire nuovamente la password");
            String passcmp = this.stringCheck();
            if (!password.equals(passcmp)) {
                System.out.println("Le password non corrispondono, riprova.");
                return passencryption();
            }
            //encrypting della password
            AESencrypt crypted = new AESencrypt();
            return AESencrypt.encrypt(password);
    }
    //sotto metodo che fa il check della stringa
    private String stringCheck(){
        Scanner sc =  new Scanner(System.in);
        String str = sc.next();
        if (!str.trim().isEmpty()) {
            System.out.println("Si prega di inserire un nome valido \ninput: ");
            return stringCheck();
        }
            return str;
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
