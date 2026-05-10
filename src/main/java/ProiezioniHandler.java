import java.util.LinkedList;
import java.util.Scanner;

public class ProiezioniHandler {
    private LinkedList<User> proiezioniList;
    
    public ProiezioniHandler (LinkedList proiezioniList){
        this.proiezioniList=proiezioniList;
    }

    public static void addProiezione(){
        Proiezioni NuovaProiezione= new Proiezioni();
        Scanner sc = new Scanner(System.in);
        boolean p=true;
        //Aggiunta titolo a nuova proiezione
        while (p){

            System.out.println("Inserire il Titolo");
            String titolo= sc.nextLine();
            NuovaProiezione.setTitolo(titolo);
            p=false;
        }
        p=true;
        
        //Inserimento genere
        while(p){
            System.out.println("Inserire il genere");
            // da aggiungere dopo aver fatto l'enum

        }
        p=true;

        //Inserimento regista
        while(p){
            //controllare come viene memorizzato all'interno del file
            System.out.println("Inserire il regista");
            String regista=sc.nextLine();
            NuovaProiezione.setRegista(regista);
            p=false;
        }
        
        //Inserimento data
        //da fare

        p=true;

        //Inserimento durata
        while(p){
            //controllare come  viene memorizzata all'interno del file (possibilmente in minuti)
            System.out.println("Inserire la durata della proiezione");
            int durata=sc.nextInt();
            NuovaProiezione.setDurata(durata);
            p=false;
        }
        p=true;

        //Inserimento etàMinima
        while(p){
            System.out.println("Inserire l'età minima");
            int etaMin=sc.nextInt();
            NuovaProiezione.setEtaMin(etaMin);
            p=false;
        }
        p=true;

        //inserimento anno d'uscita
        while(p){
            System.out.println("Inserire l'anno di pubblicazione del film");
            int anno=sc.nextInt();
            NuovaProiezione.setAnno(anno);
            p=false;
        }
        p=true;

        //inserimento del prezzo
        while(p){
            System.out.println("Inserire il prezzo del film");
            float prezzo=sc.nextFloat();
            NuovaProiezione.setPrezzo(prezzo);
            p=false;
        }
    
    }
}
