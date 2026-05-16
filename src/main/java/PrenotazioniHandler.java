import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
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

    //metodo di ricerca delle prenotazioni di uno user che ritorna una linkedlist con le prenotazioni trovate
    public LinkedList<Prenotazione> visualizzaPrenotazioni(String username){
        LinkedList<Prenotazione> foundList = new LinkedList<>(); // lista prenotazioni trovate
        for(Prenotazione p: this.prenList)
            if(p.getUsername().equals(username)) foundList.add(p);
        return foundList; // ritorna una lista vuota se non trova prenotazioni associate
    }

    //metodo di cancellamento di una prenotazione
    public boolean eliminaPrenotazione(String id){
        Iterator<Prenotazione> prenIt = this.prenList.iterator();// crea un iteratore della lista per poterla modificare mentre viene iterata (non si puo fare con foreach)
        while (prenIt.hasNext()){// continua a iterare la lista fino a che non arriva alla fine o non viene trovato un oggetto prenotazione
            Prenotazione p = prenIt.next(); // prende oggetto successivo per check
            if(p.getId().equals(id) && p.getDate().isBefore(LocalDateTime.now())) {
                prenIt.remove();
                this.fh.savePrenList(this.prenList); // salva cambiamento
                return true; // conferma rimozione
            }
        }
        return false; // conferma di non aver trovato la prenotazione da rimuovere
    }
}
