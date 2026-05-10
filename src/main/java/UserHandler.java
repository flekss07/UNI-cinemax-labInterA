import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler {
    private final LinkedList<User> userList = new LinkedList<>();
    /*Funzione x registrare l'utente*/
    public void addUser() throws Exception{
        Scanner s= new Scanner(System.in);
        //ruolo
        System.out.println("scegliere il ruolo");
        //Inserimento nome
        System.out.println("Inserire Nome");
        String nome = this.stringCheck();
        //inserimento cognome
        System.out.println("Inserire Cognome");
        String cognome = this.stringCheck();
        //inserimento username
        System.out.println("Inserire Username");
        String username = this.stringCheck();
        System.out.println("Inserire indirizzo di residenza");
        String residenza = this.stringCheck();
        //da inserire gestione della data
        System.out.println("inserire la data di nascita con formato gioni/mesi/anni");
        String bDate = this.stringCheck();
        System.out.println("inserire ruolo: ");
        String ruolo = this.stringCheck();
        //inserimento della password
        String password = this.passencryption();
        User newUser = new User(nome,cognome,password,username,bDate,residenza,ruolo);
        this.userList.add(newUser);

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
