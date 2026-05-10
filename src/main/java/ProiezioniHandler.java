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
            if(!titolo.trim().isEmpty()){
                System.out.println("Si prega di inserire un titolo valido");
            }else {
            NuovaProiezione.setTitolo(titolo);
            p=false;
            }
        }
        p=true;
        
        //Inserimento genere

            System.out.println("Inserire il genere inserendo il numerino assegnato");
            String genere = sc.nextLine();
            /*if(!genere.trim().isEmpty()){

            }*/
            // da aggiungere dopo aver fatto l'enum


        p=true;

        //Inserimento regista
        while(p) {
            //controllare come viene memorizzato all'interno del file
            System.out.println("Inserire il regista");
            String regista = sc.nextLine();
            if (!regista.trim().isEmpty()) {
                System.out.println("Si prega di inserire un regista valido");
            } else {
                NuovaProiezione.setRegista(regista);
                p = false;
            }
        }


        //Inserimento data
        //da fare

        p=true;

        //Inserimento durata
        while(p) {
            System.out.println("Inserire la durata della proiezione (in minuti)");
            String durata = sc.nextLine();

            if (!durata.trim().isEmpty()) {
                System.out.println("Inserire un dato");
            } else {
                try {
                    int durataInt = Integer.parseInt(durata);
                    if (durataInt <= 0) {
                        System.out.println("La durata inserita non può essere negativa");
                    } else {
                        NuovaProiezione.setDurata(durataInt);
                        p = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Quello che hai inserito non è un numero. Riprova");
                }
            }
        }
        p=true;

        //Inserimento etàMinima
        while(p){
            System.out.println("Inserire l'età minima");
            String etaMin = sc.nextLine();
            if(!etaMin.trim().isEmpty()){
                System.out.println("Inserire un'ètà minima valida");
            } else{
                try{
                    int etaMinInt = Integer.parseInt(etaMin);
                    if(etaMinInt>=0) {
                        if(etaMinInt>=18){
                            System.out.println("L'eta inserita supera la maggiore eta, il limite sarà impostato a 18");
                            etaMinInt = 18;
                        } else {
                            NuovaProiezione.setEtaMin(etaMinInt);
                            p = false;
                        }
                    } else{
                        System.out.println("L'eta inserita non può essere negativa");
                    }



                }catch(NumberFormatException e){
                    System.out.println("Quello che hai inserito non è un numero. Riprova");
                }
        }
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
