import java.util.Date;

public class Film {
    private Tag[] Generi;
    private String Titolo;
    private String Regista;
    private Date Data;
    private int durata;
    private int etaMin;

    public Tag[] getGeneri() {
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