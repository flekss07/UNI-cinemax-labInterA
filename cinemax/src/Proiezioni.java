import java.util.Date;

public class Proiezioni {
    private String genere;
    private String titolo;
    private String regista;
    private Date data;
    private int durata;
    private int etaMin;

    public Proiezioni(String genere, String titolo, String regista,Date data,int durata,int etaMin){
        this.genere = genere;
        this.titolo = titolo;
        this.regista = regista;
        this.data = data;
        this.durata = durata;
        this.etaMin = etaMin;
    }

    // getter

    public String getGeneri() { return this.genere; }

    public String getTitolo() { return this.titolo; }

    public String getRegista() { return this.regista; }

    public Date getData() { return this.data; }

    public int getDurata() { return this.durata; }

    public int getEtaMin() { return this.etaMin; }

    // setter

    public void setGeneri(String genere){ this.genere = genere; }

    public void setTitolo(String titolo){ this.titolo = titolo; }

    public void setRegista(String regista){ this.regista = regista; }

    public void setData(Date data){ this.data = data; }

    public void setDurata(int durata){ this.durata = durata; }

    public void setEtaMin(int etaMin){ this.etaMin = etaMin; }
}