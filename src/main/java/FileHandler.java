import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class
FileHandler {
    private DateTimeFormatter formatter; // formatter per convertire da LocalDateTime a string
    private DateTimeFormatter localDateFormatter;
    private LinkedList<Proiezioni> proList; // linkedlist
    private LinkedList<User> userList;
    private String proCsvPath;// percorso file csv proiezioni
    private String userCsvPath; // percorso file csv user
    public FileHandler() {
        this.proList = new LinkedList<>(); // inizializza linkedlist proiezioni
        this.userList = new LinkedList<>(); // inizializza linkedlist user
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    // metodo per caricare i dati delle proiezioni da csv
    private void loadProData(String filePath) throws IOException {
        Path path = Paths.get("data",filePath);
        BufferedReader br = Files.newBufferedReader(path); // crea un reader per il file csv che usa inputstream per processare il testo
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim().parse(br); // crea un parser dedicato per il csv che usa gli header come nomi delle colonne
        for (CSVRecord record : parser) // itera ogni elemento letto dal csvparser per estrarne i dati
            this.createProObj(record); //crea oggetto proiezione e lo aggiunge alla linkedlist dedicata
    }

    // sotto metodo che crea oggetti della classe proiezione e gli assegna i dati
    private void createProObj(CSVRecord record) {
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
    private LocalDateTime convertDate(String strDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // imposta pattern di formattazione data
        LocalDateTime projectionDate = LocalDateTime.parse(strDate, formatter); // fa il parse della data nel formato preimpostato
        return projectionDate;
    }

    //metodo di testing per convertire i dati di un oggetto proiezione in una stringa
    private String printProj(Proiezioni p) {
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

    //metodo di testing per stampare i dati delle proiezioni
    public void printProiezioni() {
        for (Proiezioni p : proList)
            System.out.println(this.printProj(p));
    }

    //metodo che salva i dati delle proiezioni su file
    public void writeToProCsv(String path) throws IOException {
        Writer writer = new FileWriter(path); // crea writer per scrivere su file
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT); // crea csv printer per creare record da scrivere su file
        this.createHeader(printer);
        for (Proiezioni pro : this.proList)
            this.createProRecord(pro,printer);
        printer.flush(); // fa scrivere su file tutti i record stampati dal printer csv
        printer.close(); // chiude printer stream
        writer.close(); // chiude writer
    }

    //sotto metodo che cra un header per riscrivere il csv
    private void createHeader(CSVPrinter printer) throws IOException {
        printer.printRecord(
                "data_ora_proiezione",
                "titolo_film",
                "genere",
                "regista",
                "anno",
                "durata_minuti",
                "eta_minima",
                "prezzo_biglietto"
        );
    }

    // sotto metodo che crea un record della proiezione selezionata per stampare su csv
    private void createProRecord(Proiezioni p, CSVPrinter printer) throws IOException {
        printer.printRecord(
                p.getData().format(this.formatter),
                p.getTitolo(),
                p.getGeneri(),
                p.getRegista(),
                p.getAnno(),
                p.getDurata(),
                p.getEtaMin(),
                p.getPrezzo()
        );
    }

    // metodo che prende i dati dal csv degli utenti e li inserisce nella linkedlist dedicata
    public void LoadUserData(String filePath) throws IOException {
        Path path = Paths.get("data",filePath);
        BufferedReader br = Files.newBufferedReader(path); // crea un reader per il file csv che usa inputstream per processare il testo
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim().parse(br); // crea un parser dedicato per il csv che usa gli header come nomi delle colonne
        for (CSVRecord record : parser) // itera ogni elemento letto dal csvparser per estrarne i dati
            this.createUserObj(record); //crea oggetto proiezione e lo aggiunge alla linkedlist dedicata
    }

    // metodo che crea un oggetto della classe user usando i dati passati dal csv
    private void createUserObj(CSVRecord record){
        String nome = record.get("nome");
        String cognome = record.get("cognome");
        String password = record.get("password");
        String username = record.get("username");
        LocalDate dataDiNascita =  LocalDate.parse(record.get("data_di_nascita")); // converte la data di nascita in formato date
        String indirizzo = record.get("indirizzo");
        Roles ruolo = Roles.CLIENTE;
        User u = new User(nome,cognome,password,username,dataDiNascita,indirizzo,ruolo); // crea nuovo oggetto user con i dati
        this.userList.add(u); // aggiunge user alla linkedlist dedicata
    }

    //metodo per scrivere sul csv degli user
    public void WriteToUserCsv(String path)throws IOException {
        Writer writer = new FileWriter(path); // crea writer per scrivere su file
        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT); // crea csv printer per creare record da scrivere su file
        this.createUserHeader(printer);
        for (User u : this.userList)
            this.createUserRecord(u,printer);
        printer.flush(); // fa scrivere su file tutti i record stampati dal printer csv
        printer.close(); // chiude printer stream
        writer.close(); // chiude writer
    }

    //sotto metodo per creare gli header dello user.csv
    private void createUserHeader(CSVPrinter printer) throws IOException {
        printer.printRecord(
                "nome",
                "cognome",
                "password",
                "username",
                "data_di_nascita",
                "indirizzo",
                "ruolo"
        );
    }

    // sotto metodo che crea un record dello user selezionato da stampare su csv
    private void createUserRecord(User u, CSVPrinter printer) throws IOException {
        printer.printRecord(
                u.getNome(),
                u.getCognome(),
                u.getPassword(),
                u.getPassword(),
                u.getDataDiNascita().format(this.localDateFormatter),
                u.getIndirizzo()
        );
    }

    //metodo che fa il get della linkedlist delle proiezioni
    public LinkedList<Proiezioni> getProList(String path){
        if(!this.proList.isEmpty()) // se la linkedlist è già caricata la restituisce
            return this.proList;
        else
            try {
                this.loadProData(path); // se linkedlist è vuota la carica da csv
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        return getProList(path); // richiama la funzione per verificare e restituire i dati
    }

    //metodo che fa il salvataggio della linkedlist passata su file csv proiezioni
    public void saveProList(LinkedList<Proiezioni> proList){
        this.proList = proList; // aggiorna lista salvata in cache
        try {
            this.writeToProCsv("proiezioni.csv"); // riscrive file proiezioni csv
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
