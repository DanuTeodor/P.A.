package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil instance = null;
    private EntityManagerFactory factory;

    private PersistenceUtil() {
        factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public static PersistenceUtil getInstance() {
        if (instance == null)
            instance = new PersistenceUtil();

        return instance;
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }
}