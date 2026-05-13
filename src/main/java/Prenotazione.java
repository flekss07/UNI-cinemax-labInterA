import java.time.LocalDateTime;

public class Prenotazione {
    private User user;
    private Proiezioni pro;

    public Prenotazione(User user, Proiezioni pro) {
        this.user = user;
        this.pro = pro;
    }

    public LocalDateTime getDAte(){ return this.pro.getData(); }
    public String getTitolo(){ return this.pro.getTitolo(); }
    public String getUsername(){ return this.user.getUsername(); }

}
