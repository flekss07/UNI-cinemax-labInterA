import java.util.LinkedList;
import java.util.Scanner;

public class UserHandler {
    private final LinkedList<User> userList = new LinkedList<>();

    /*Funzione x registrare l'utente*/
    public void addUser() throws Exception{
        Scanner s= new Scanner(System.in);
        User newUser = new User();
        boolean x=true; //variabile di controllo sui cicli while

        //ruolo
        System.out.println("scegliere il ruolo");

        //da inserire gestione errore nel caso si eviti di inserire il campo
        while(x) {
            System.out.println("Inserire Nome");
            String nome = s.nextLine();
            if(!nome.isEmpty() &&!nome.trim().isEmpty()) {
            System.out.println("Si prega di inserire un nome valido");
            } else{
                newUser.setNome(nome);
                x= false;
            }
        }
        x= true;
        while(x) {
            System.out.println("Inserire Cognome");
            String cognome = s.nextLine();
            if(!cognome.isEmpty() &&!cognome.trim().isEmpty()) {
                System.out.println("Si prega di inserire un cognome valido");
            } else{
                newUser.setCognome(cognome);
                x= false;
            }
        }
        x = true;
        while(x) {
            System.out.println("Inserire Username");
            String username = s.nextLine();
            if(!username.isEmpty() &&!username.trim().isEmpty()) {
                System.out.println("Si prega di inserire un username valido");
            } else{
            newUser.setUsername(username);
            x= false;
            }
        }
        x = true;
        while(x) {
            System.out.println("Inserire indirizzo di residenza");
            String indirizzo = s.nextLine();
            if(!indirizzo.isEmpty() &&!indirizzo.trim().isEmpty()) {
                System.out.println("Si prega di inserire un indirizzo valido");
            }else{
                    newUser.setIndirizzo(indirizzo);
            x= false;}


        }
        //da inserire gestione della data
        System.out.println("inserire la data con formato gioni/mesi/anni");
           
        //inserimento della password 
        while (x) {
            System.out.println("inserire una password");
            String password = s.nextLine();

            System.out.println("inserire nuovamente la password");
            String passcmp = s.nextLine();
        if (!password.isEmpty() &&!password.trim().isEmpty()) {
            System.out.println("Si prega di inserire una password valida");
        } else if (!password.equals(passcmp)) {
            System.out.println("Le password non corrispondono, riprova.");
        } else if(password.equals(passcmp)){
            //encrypting della password
            AESencrypt crypted = new AESencrypt();
            newUser.setPassword(AESencrypt.encrypt(password));
            x=false;
        }
    }  
    s.close();

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