import java.time.LocalDate;
import java.time.LocalDateTime;

public class Proiezioni {
    private Genres genere; // da modifica in enum
    private String titolo;
    private String regista;
    private LocalDate data;
    private int durata;
    private int etaMin;
    private int anno;
    private float prezzo;

    public Proiezioni(Genres genere, String titolo, String regista, LocalDate data, int durata, int etaMin, int anno, float prezzo){
        this.genere = genere;
        this.titolo = titolo;
        this.regista = regista;
        this.data = data;
        this.durata = durata;
        this.etaMin = etaMin;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    public Proiezioni(){

    }
    // getter

    public Genres getGeneri() { return this.genere; }

    public String getTitolo() { return this.titolo; }

    public String getRegista() { return this.regista; }

    public LocalDate getData() { return this.data; }

    public int getDurata() { return this.durata; }

    public int getEtaMin() { return this.etaMin; }

    public int getAnno(){ return this.anno; }

    public float getPrezzo(){ return this.prezzo;}
    // setter

    public void setGeneri(Genres genere){ this.genere = genere;  }

    public void setTitolo(String titolo){ this.titolo = titolo; }

    public void setRegista(String regista){ this.regista = regista; }

    public void setData(LocalDate data){ this.data = data; }

    public void setDurata(int durata){ this.durata = durata; }

    public void setEtaMin(int etaMin){ this.etaMin = etaMin; }

    public void setAnno(int anno){ this.anno = anno; }

    public void setPrezzo(float prezzo){ this.prezzo = prezzo; }
}