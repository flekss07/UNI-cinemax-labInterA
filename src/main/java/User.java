import java.util.Date;

public class User {
    private String nome;
    private String cognome;
    private String password;
    private String username;
    private Date dataDiNascita;
    private String indirizzo;

    public User(String nome, String cognome, String password, String username,Date dataDiNascita,String indirizzo){
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
        this.username = username;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
    }

    // getter

    public String getNome(){ return this.nome; }
    public String getCognome(){ return this.cognome; }
    public String getPassword(){ return this.password; }
    public String getUsername(){ return this.username; }
    public Date getDataDiNascita() { return this.dataDiNascita; }
    public String getIndirizzo() { return this.indirizzo; }

    //setter

    public void setNome(String nome){ this.nome = nome; }
    public void setCognome(String cognome){ this.cognome = cognome; }
    public void setPassword(String password){ this.password = password; }
    public void setUsername(String username){ this.username = username; }
    public void setDataDiNascita(Date dataDiNascita){ this.dataDiNascita = dataDiNascita; }
    public void setIndirizzo(String indirizzo){ this.indirizzo = indirizzo; }
}
