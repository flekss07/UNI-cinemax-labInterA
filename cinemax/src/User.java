import java.util.Date;

public class User {
    private String Nome;
    private String Cognome;
    private String Password;
    private String Username;
    private Date DataDiNascita;
    private String Indirizzo;

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return Cognome;
    }
    /* Da implementare la funzione di encryption */
    public String getPassword(){
        return Password;
    }

    public String getUsername() {
        return Username;
    }

    public Date getDataDiNascita() {
        return DataDiNascita;
    }

    public String getIndirizzo() {
        return Indirizzo;
    }
}

