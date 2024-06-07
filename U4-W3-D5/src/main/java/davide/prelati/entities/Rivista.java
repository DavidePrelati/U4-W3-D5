package davide.prelati.entities;

import davide.prelati.enums.Periodicita;
import jakarta.persistence.Entity;

@Entity
public class Rivista extends Catalogo {
    private Periodicita periodicita;

    public Rivista() {

    }

    public Rivista(String titolo, int anno_pubblicazione, int num_pagine, Periodicita periodicita) {
        super(titolo, anno_pubblicazione, num_pagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", isbn=" + isbn +
                ", num_pagine=" + num_pagine +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", titolo='" + titolo + '\'' +
                '}';
    }
}
