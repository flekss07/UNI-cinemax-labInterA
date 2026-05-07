import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {
    private String path;
    private ArrayList<String[]> cachedData; // linked list dove caricare i dati presi da csv per caching
    private static FileHandler fh; // istanza statica di FileHandler usata per salvare globalmente i dati in cache

    public FileHandler(String path) {
        this.path = path; // assegna path per file
        this.cachedData = new ArrayList<>(); // inizializza la lista dati della cache
        this.loadData(); // carica i dati
    }

    // metodo usato per creare un istanza di fileHandler utilizzabile da altre classi senza perdere dati cache
    public static FileHandler getIstance(String path){
        if( fh == null) // se istanza di fileHandler non esiste ancora
            fh = new FileHandler(path); // crea istanza di fileHandler
        return fh; // ritorna istanza statica di fileHandler
    }

    // metodo che fa il load dei dati da file .csv
    private void loadData(){
        InputStream is = getClass().getClassLoader().getResourceAsStream(this.path);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))){// crea oggetto br per leggere dal file
            String dataLine; // stringa dove caricare la linea corrente da csv
            while ((dataLine = br.readLine()) != null) { // legge il file linea per linea
                String[] dataArray = dataLine.split(","); // divide la stringa nell'array splittando alla ,
                this.cachedData.add(dataArray); // aggiunge l'array di dati nella linkedlist della cache
            }
        }catch(IOException e){ // gestisce esception
            System.out.println("erroe nel caricamento del file dati: " + e.getMessage()); // stampa errore relativo al file
        }
    }

    public void printData(){
        for(String[] dataString: this.cachedData) // itera gli array in cache
            System.out.println(Arrays.toString(dataString)); // stampa l'array in formato stringa
    }
}