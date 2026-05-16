import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Main {


    static void main(String[] args){
        FileHandler fh = new FileHandler("users.csv");
        UserHandler uh = new UserHandler();
        /*Menu menu = new Menu();
        try {
            menu.menuSelect();
        }catch(Exception e){
            System.out.println("errore in main adduser");
            throw new RuntimeException(e);
        }
        */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        PrenotazioniHandler ph = new PrenotazioniHandler();
        ph.createBooking("test","test title",LocalDateTime.parse("2006-11-11 12:30", formatter),UUID.randomUUID().toString());
    }
}
