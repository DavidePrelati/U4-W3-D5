package davide.prelati.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_prestito;

    private Date inizio_prestito;
    private Date fine_prestito;
    private Date restituzione;
    @ManyToOne
    @JoinColumn(name = "catalogo_id")
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Prestito() {

    }

    public Prestito(Date inizio_prestito, Date fine_prestito, Date restituzione) {
        this.inizio_prestito = inizio_prestito;
        this.fine_prestito = fine_prestito;
        this.restituzione = restituzione;
    }

    public long getId_prestito() {
        return id_prestito;
    }

    public Date getInizio_prestito() {
        return inizio_prestito;
    }

    public void setInizio_prestito(Date inizio_prestito) {
        this.inizio_prestito = inizio_prestito;
    }

    public Date getFine_prestito() {
        return fine_prestito;
    }

    public void setFine_prestito(Date fine_prestito) {
        this.fine_prestito = fine_prestito;
    }

    public Date getRestituzione() {
        return restituzione;
    }

    public void setRestituzione(Date restituzione) {
        this.restituzione = restituzione;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id_prestito=" + id_prestito +
                ", inizio_prestito=" + inizio_prestito +
                ", fine_prestito=" + fine_prestito +
                ", restituzione=" + restituzione +
                '}';
    }
}
