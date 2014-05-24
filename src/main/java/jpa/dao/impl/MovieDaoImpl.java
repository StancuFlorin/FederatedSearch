package jpa.dao.impl;

import jpa.dao.MovieDao;
import jpa.models.MovieModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by fstancu on 5/22/2014.
 */

@Repository
public class MovieDaoImpl implements MovieDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MovieModel find(int movieID) {
        return entityManager.find(MovieModel.class, movieID);
    }

    @Override
    public void save(MovieModel toBeSaved) {
        entityManager.persist(toBeSaved);
    }

    @Override
    public void update(MovieModel toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    @Override
    public void remove(MovieModel toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }
}
