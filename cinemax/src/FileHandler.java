import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
    private String path;
    private ArrayList<Proiezioni> proiezioni; // linked list per i dati delle proiezioni
    private ArrayList<User> users; // linked list per i dati degli utenti
    private static FileHandler fh; // istanza statica di FileHandler usata per salvare globalmente i dati in cache

    public FileHandler() {
        this.users = new ArrayList<>(); // inizializza lista user
        this.proiezioni = new ArrayList<>(); // inizializza lista prenotazioni
    }

    // metodo che fa il load dei dati da file .csv
    public void loadProiezioniData(String path) throws IOException{
        InputStream is = getClass().getClassLoader().getResourceAsStream(path); // metodo di ricerca del file dati universale
        BufferedReader br = new BufferedReader(new InputStreamReader(is));// crea oggetto br per leggere dal file
        String dataLine; // stringa dove caricare la linea corrente da csv
        while ((dataLine = br.readLine()) != null) { // legge il file linea per linea


        }
    }

    //sotto metodo che formatta i dati del csv delle proiezioni e li inserisce in un oggetto
    private Proiezioni formatProiezione(String dataLine){
        String[] dataArray = dataLine.split(","); // divide la stringa nell'array splittando alla ,
        Proiezioni pr = new Proiezioni();
    }



    public void printData(){
        for(String[] dataString: this.cachedData) // itera gli array in cache
            System.out.println(Arrays.toString(dataString)); // stampa l'array in formato stringa
    }
}