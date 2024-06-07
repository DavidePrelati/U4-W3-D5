package davide.prelati;

import davide.prelati.dao.CatalogoDao;
import davide.prelati.entities.Libro;
import davide.prelati.entities.Rivista;
import davide.prelati.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        CatalogoDao cd = new CatalogoDao(em);

        Libro libro_1 = new Libro("Libro della giungla", 1987, 234, "Franco", "avventura");
        Rivista rivista_1 = new Rivista("Dragon Ball Z", 1983, 290, Periodicita.MENSILE);

        cd.save(libro_1);
        cd.save(rivista_1);

    }
}