import java.util.Scanner;

public class Menu {
    private UserHandler uh;

    public Menu() { //costruzione oggetto classe userhandler
        this.uh = new UserHandler();
    }

    public void MenuSelect() { // costruttore menu
        int selector = 3;
        while () {
            switch (selector) {
                case 1://registrarsi
                    try {
                        this.userRegister();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                case 2://login
                    this.userLogin();
                    break;
                case 3://guest
                    this.Guest();
                    break;
                default:
                    System.out.println("Qualcosa è andato storto...");
            }
        }


    }



    public  void userRegister() throws Exception {
        //ruolo
        System.out.println("scegliere il ruolo");
        //Inserimento nome
        System.out.println("Inserire Nome");
        String nome = this.stringCheck();
        //inserimento cognome
        System.out.println("Inserire Cognome");
        String cognome = this.stringCheck();
        //inserimento username
        System.out.println("Inserire Username");
        String username = this.stringCheck();
        System.out.println("Inserire indirizzo di residenza");
        String residenza = this.stringCheck();
        //da inserire gestione della data
        System.out.println("inserire la data di nascita con formato gioni/mesi/anni");
        String bDate = this.stringCheck();
        System.out.println("inserire ruolo: ");
        String ruolo = this.stringCheck();
        //inserimento della password
        String password = this.passencryption();

    }
    private String stringCheck() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (!str.trim().isEmpty()) {
            System.out.println("Si prega di inserire un input valido \ninput: ");
            return stringCheck();
        }
        return str;
    }

    private String passencryption() throws Exception {
        System.out.println("inserire una password");
        String password = this.stringCheck();
        System.out.println("inserire nuovamente la password");
        String passcmp = this.stringCheck();
        if (!password.equals(passcmp)) {
            System.out.println("Le password non corrispondono, riprova.");
            return passencryption();
        }
        //encrypting della password
        AESencrypt crypted = new AESencrypt();
        return AESencrypt.encrypt(password);
    }

}