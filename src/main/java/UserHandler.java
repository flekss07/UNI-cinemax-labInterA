import java.util.LinkedList;

public class UserHandler {
    private LinkedList<User> userList = new LinkedList<>();
    User newUser;
    /*Funzione x registrare l'utente*/
    public void addUser(User user) {
        
        userList.add(user);
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




