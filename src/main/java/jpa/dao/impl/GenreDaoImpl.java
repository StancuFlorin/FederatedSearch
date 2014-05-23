package jpa.dao.impl;

import jpa.dao.GenreDao;
import jpa.models.GenreModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by fstancu on 5/22/2014.
 */

@Repository
public class GenreDaoImpl implements GenreDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public GenreModel find(int genreID) {
        return entityManager.find(GenreModel.class, genreID);
    }

    @Override
    public void save(GenreModel toBeSaved) {
        entityManager.persist(toBeSaved);
    }

    @Override
    public void update(GenreModel toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    @Override
    public void remove(GenreModel toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }
}
