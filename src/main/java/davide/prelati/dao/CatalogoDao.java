package davide.prelati.dao;

import davide.prelati.entities.Catalogo;
import davide.prelati.entities.Libro;
import davide.prelati.entities.Rivista;
import davide.prelati.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogoDao {
    private EntityManager em;

    public CatalogoDao(EntityManager em) {
        this.em = em;
    }


    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("Catalogo " + catalogo.getTitolo() + " salvato correttamente");
    }

    public void findCatalogosByISBNAndDelete(long isbn) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query deleteQuery = em.createQuery("DELETE FROM Catalogo a WHERE a.isbn = :isbn");
        deleteQuery.setParameter("isbn", isbn);
        int numeroCancellati = deleteQuery.executeUpdate();

        transaction.commit();
        System.out.println(numeroCancellati + " cataloghi con id " + isbn + " cancellati correttamente");
    }


    public Catalogo findByISBN(long isbn) {
        Catalogo catalogo = em.find(Catalogo.class, isbn);
        if (catalogo == null) throw new NotFoundException(isbn);
        return catalogo;
    }

    public Catalogo findCatalogoByYear(int year) {
        Catalogo catalogo = em.find(Catalogo.class, year);
        if (catalogo == null) throw new NotFoundException(year);
        return catalogo;
    }

    public Libro findLibroByAuthor(String autore) {
        Libro libro = em.find(Libro.class, autore);
        return libro;
    }

    public List<Catalogo> findAllByTitle(String titolo, String titoloLettera) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo =:titolo OR c.titolo =:titoloLettera", Catalogo.class);
        query.setParameter("titolo", titolo);
        query.setParameter("titoloLettera", titoloLettera);
        return query.getResultList();
    }

    public List<Rivista> findAllRivistas() {
        TypedQuery<Rivista> query = em.createQuery("SELECT d FROM Rivista d", Rivista.class); // SELECT * FROM catalogos WHERE tipo_catalogoe = 'Cane' (Per la single table)
        return query.getResultList();
    }

    public List<Libro> findAllLibros() {
        TypedQuery<Libro> query = em.createQuery("SELECT c FROM Libro c", Libro.class); // SELECT * FROM catalogos WHERE tipo_catalogoe = 'Gatto' (Per la single table)
        return query.getResultList();
    }

    public List<String> findAllCatalogosNames() {
        TypedQuery<String> query = em.createQuery("SELECT a.name FROM Catalogo a", String.class);
        return query.getResultList();
    }

    public List<Catalogo> findByName(String name) {
        // 1. Richiamo la named query "findByName" definita nell'entità Catalogo
        TypedQuery<Catalogo> query = em.createNamedQuery("findByName", Catalogo.class);

        // 2. Passo un valore per il parametro name della query
        query.setParameter("name", name);

        // 3. Eseguo la query e ritorno il risultato
        return query.getResultList();
    }


    public void findCatalogosByNameAndUpdateName(String oldName, String newName) {
        // Quando si parla di operazioni che vanno a modificare il db come save,update,delete,ecc devo usare le transazioni
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query deleteQuery = em.createQuery("UPDATE FROM Catalogo a SET a.name = :newName WHERE a.name = :oldName"); // UPDATE FROM catalogos SET name = 'nomenuovo' WHERE name = 'nomevecchio'
        deleteQuery.setParameter("oldName", oldName);
        deleteQuery.setParameter("newName", newName);
        int numeroModificati = deleteQuery.executeUpdate();

        transaction.commit();
        System.out.println(numeroModificati + " catalogoi di nome " + oldName + " rinominati correttamente in " + newName);
    }

    public List<Catalogo> findByNameStartsWith(String partialName) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT a FROM Catalogo a WHERE LOWER(a.name) LIKE LOWER(:partialName)", Catalogo.class);
        // Siccome ILIKE non è compatibile con tutti i db relazionali, meglio non usarlo e usare lo stratagemma di qua sopra
        query.setParameter("partialName", partialName + "%");
        return query.getResultList();
    }

    public List<Catalogo> findByOwnerName(String ownerName) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT a FROM Catalogo a WHERE a.owner.name = :ownerName", Catalogo.class);
        query.setParameter("ownerName", ownerName);
        return query.getResultList();
    }

    // JPQL Operators --> https://www.objectdb.com/java/jpa/query/jpql/structure


}