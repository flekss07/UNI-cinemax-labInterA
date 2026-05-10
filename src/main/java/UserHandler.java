import java.util.LinkedList;

public class UserHandler {
    private LinkedList<User> userList;

    public UserHandler(LinkedList<User> userList){
        this.userList=userList;
    }

    /*Metodo x registrare l'utente*/
    public void addUser(User newUser){
        logUser(newUser);
               
    }
    
    /* Metodo per controllare se l'utente esiste già*/
    public void logUser(User newUser){
        for (int i = 0; i < userList.size(); i++) {
            User newUser2=userList.get(i);
            if(newUser2.getUsername()==newUser.getUsername()){
                //to update into trow UserAlreadyExistingException
                System.err.println("Utente già esistente");
            }
        }
    }



}
