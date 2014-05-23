package jpa.dao.impl;

import jpa.dao.ShowDao;
import jpa.models.ShowModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by fstancu on 5/22/2014.
 */

@Repository
public class ShowDaoImpl implements ShowDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ShowModel find(int showID) {
        return entityManager.find(ShowModel.class, showID);
    }

    @Override
    public void save(ShowModel toBeSaved) {
        entityManager.persist(toBeSaved);
    }

    @Override
    public void update(ShowModel toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    @Override
    public void remove(ShowModel toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }
}
