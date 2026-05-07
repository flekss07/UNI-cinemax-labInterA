public class Main {
    public static void main(String[] args){
        FileHandler fh = FileHandler.getIstance("data/proiezioni.csv");
        fh.printData();
    }
}
