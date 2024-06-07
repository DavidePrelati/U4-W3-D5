package davide.prelati.entities;

import jakarta.persistence.Entity;

@Entity

public class Libro extends Catalogo {

    private String autore;
    private String genere;

    public Libro(String titolo, int anno_pubblicazione, int num_pagine, String autore, String genere) {
        super(titolo, anno_pubblicazione, num_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", num_pagine=" + num_pagine +
                '}';
    }
}
