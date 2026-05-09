import java.util.LinkedList;

public class UserHandler {
    private LinkedList<User> userList = new LinkedList<>();
    User newUser;
    /*Funzione x registrare l'utente*/
    public boolean addUser(User user) {
        // Controlliamo se l'username è già preso
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {
                System.out.println("Errore: Username già esistente.");
                return false;
            }
        }
        userList.add(user);
        return true;
    }
}
/* funzione per controllare se l'utente esiste già*/
public void logUser(){

}



