package repo;

import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private EntityManager entityManager;

    public ArtistRepository() {
        entityManager = PersistenceUtil.getInstance()
                .getFactory()
                .createEntityManager();
    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public Artist findById(int id) {
        Artist artist = entityManager.find(Artist.class, id);
        return artist;
    }

    public List<Artist> findByName(String name) {
        List<Artist> artist = entityManager.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
        return artist;
    }
}