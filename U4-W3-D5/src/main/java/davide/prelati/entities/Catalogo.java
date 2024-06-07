package davide.prelati.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_catalogo")
public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long isbn;
    protected String titolo;
    protected int anno_pubblicazione;
    protected int num_pagine;

    public Catalogo() {

    }

    public Catalogo(String titolo, int anno_pubblicazione, int num_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.num_pagine = num_pagine;
    }

    public long getIsbn() {
        return isbn;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(int anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNum_pagine() {
        return num_pagine;
    }

    public void setNum_pagine(int num_pagine) {
        this.num_pagine = num_pagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "isbn=" + isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", num_pagine=" + num_pagine +
                '}';
    }
}
