import java.util.Date;
//placeholder data names
public class Film {
    private Genres[] Generi;
    private String Titolo;
    private String Regista;
    private Date Data;
    private int durata;
    private int etaMin;
    //placeholder data names
    public Film(String Titolo,Genres[] Genres, String Regista, Date Data, int durata, int etaMin){
        this.Titolo = Titolo;
        this.Generi = Genres;
        this.Regista = Regista;
        this.Data = Data;
        this.durata = durata;
        this.etaMin = etaMin;
    }
    public Genres[] getGeneri() {
        return Generi;
    }

    public String getTitolo() {
        return Titolo;
    }

    public String getRegista() {
        return Regista;
    }

    public Date getData() {
        return Data;
    }

    public int getDurata() {
        return durata;
    }

    public int getEtaMin() {
        return etaMin;
    }
}