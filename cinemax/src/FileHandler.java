import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    private String path;
    private ArrayList<String[]> cachedData; // linked list dove caricare i dati presi da csv per caching
    private static FileHandler fh; // istanza statica di FileHandler usata per salvare globalmente i dati in cache

    public FileHandler(String path) {
        this.path = path; // assegna path per file
        this.loadData();
    }

    // metodo usato per creare un istanza di fileHandler utilizzabile da altre classi senza perdere dati cache
    public static FileHandler getIstance(String path){
        if( fh == null) // se istanza di fileHandler non esiste ancora
            fh = new FileHandler(path); // crea istanza di fileHandler
        return fh; // ritorna istanza statica di fileHandler
    }

    // metodo che fa il load dei dati da file .csv
    private void loadData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.path)); // crea oggetto br per leggere dal file
        String dataLine; // stringa dove caricare la linea corrente da csv
        while ((dataLine = br.readLine()) != null) { // legge il file linea per linea
            String[] dataArray = dataLine.split(","); // divide la stringa nell'array splittando alla ,
            this.cachedData.add(dataArray); // aggiunge l'array di dati nella linkedlist della cache
        }
    }

    public void printData(){
        for(String[] dataString: this.cachedData)
            System.out.println(dataString);
    }
}