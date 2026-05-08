import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FileHandler {
    private LinkedList<Proiezioni> proList; // linkedlist

    public FileHandler(){
        this.proList = new LinkedList<>(); // inizializza linked list
    }

    // metodo per caricare i dati delle proiezioni da csv
    public void LoadProData(String path)throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(path); // caricac il csv dalla cartella resources
        if (is == null) // guard clause, se il file non viene trovato lancia una exception
            throw new IOException("file non trovato con il percorso: " + path); // indica che il file non è stato trovato
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); // crea un reader per il file csv che usa inputstream per processare il testo
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim().parse(br); // crea un parser dedicato per il csv che usa gli header come nomi delle colonne
        for(CSVRecord record : parser) // itera ogni elemento letto dal csvparser per estrarne i dati
            this.createProObj(record); //crea oggetto proiezione e lo aggiunge alla linkedlist dedicata
    }

    // sotto metodo che crea oggetti della classe proiezione e gli assegna i dati
    private void createProObj(CSVRecord record){
        LocalDateTime date = convertDate(record.get("data_ora_proiezione")); // converte la data in formate LocalDateTime
        String titolo = record.get("titolo_film");
        String genere = record.get("genere");
        String regista = record.get("regista");
        int anno = Integer.parseInt(record.get("anno")); // converte in formato in
        int durata = Integer.parseInt(record.get("durata_minuti"));
        int etaMin = Integer.parseInt(record.get("eta_minima"));
        float prezzo = Float.parseFloat(record.get("prezzo_biglietto"));
        Proiezioni p = new Proiezioni(genere, titolo, regista, date, durata, etaMin, anno, prezzo); // crea oggetto proiezioni
        this.proList.add(p); // aggiunge oggetto proiezioni alla linkedlist delle proiezioni
    }

    // sotto metodo per convertire le stringhe in formato Date
    private LocalDateTime convertDate(String strDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // imposta pattern di formattazione data
        LocalDateTime projectionDate = LocalDateTime.parse(strDate, formatter); // fa il parse della data nel formato preimpostato
        return projectionDate;
    }

    //metodo di testing per stampare tutte le proiezioni in store
    public String printProj(Proiezioni p) {
        return "Proiezioni{" +
                "titolo='" + p.getTitolo() + '\'' +
                ", genere='" + p.getGeneri() + '\'' +
                ", regista='" + p.getRegista() + '\'' +
                ", data=" + p.getData() +
                ", anno=" + p.getAnno() +
                ", durata=" + p.getDurata() +
                ", etaMin=" + p.getEtaMin() +
                ", prezzo=" + p.getPrezzo() +
                '}';
    }

    public void printProiezioni() {

        for (Proiezioni p : proList) {
            System.out.println(this.printProj(p));
        }
    }
}
