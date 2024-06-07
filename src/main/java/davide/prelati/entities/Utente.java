package davide.prelati.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {

    @OneToMany(mappedBy = "utente")
    protected List<Prestito> prestiti;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero_tessera;
    private String nome;
    private String cognome;
    private Date data_nascita;

    public Utente() {

    }

    public Utente(String nome, String cognome, Date data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getNumero_tessera() {
        return numero_tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numero_tessera=" + numero_tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
