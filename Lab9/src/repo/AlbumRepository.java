package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {
    private EntityManager entityManager;

    public AlbumRepository() {
        entityManager = PersistenceUtil.getInstance()
                .getFactory()
                .createEntityManager();
    }

    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    public Album findById(int id) {
        return entityManager.find(Album.class, id);
    }

    public List<Album> findByName(String name) {
        List<Album> albums = entityManager.createNamedQuery("Album.findByName")
                .setParameter("name", name)
                .getResultList();
        return albums;
    }

    public List<Album> findByArtist(Artist artist) {
        List<Album> albums = entityManager.createNamedQuery("Album.findByArtist")
                .setParameter("artistId", artist.getId())
                .getResultList();
        return albums;
    }
}