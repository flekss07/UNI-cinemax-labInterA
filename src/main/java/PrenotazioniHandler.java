import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.UUID;

public class PrenotazioniHandler {
    private LinkedList<Prenotazione> prenList;
    private FileHandler fh;
    public PrenotazioniHandler(){
        this.fh = new FileHandler("prenotazioni.csv");
        this.prenList = this.fh.getPrenList();
    }

    //metodo che crea una nuova prenotazione
    public void createBooking(String username, String titolo, LocalDateTime date, String id){
        Prenotazione p = new Prenotazione(username,titolo, date,id);
        this.prenList.add(p);
        this.fh.savePrenList(this.prenList);
    }


}
