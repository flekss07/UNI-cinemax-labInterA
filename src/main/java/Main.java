import java.io.IOException;

public class Main {
    public static void main(String[] args){
        FileHandler fh = new FileHandler();
        try {
            fh.LoadProData("proiezioni.csv");
            fh.printProiezioni();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
