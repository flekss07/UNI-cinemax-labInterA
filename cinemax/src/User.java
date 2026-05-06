import java.util.Date;

public class User {
    String Nome;
    String Cognome;
    String Password;
    String Username;
    Date DataDiNascita;
    String Indirizzo;
    public User(String Nome, String Cognome, String Password, String Username, Date DataDiNascita) {
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Password = Password;
        this.Username = Username;
        this.DataDiNascita = DataDiNascita;
        this.Indirizzo = "";
    }

}
