import java.util.LinkedList;
import java.util.UUID;

public class PrenotazioniHandler {
    private LinkedList<Prenotazione> prenList;
    private FileHandler fh;
    public PrenotazioniHandler(){
        this.fh = new FileHandler("prenotazioni.csv");
        this.pre = this.fh.getPrenList();
    }

    //metodo che crea una nuova prenotazione
    public void createBooking(User u, Proiezioni pro, String id){
        Prenotazione p = new Prenotazione(u,pro,id);
        this.prenList.add(p);
    }


}
