package jpa.dao.impl;

import jpa.dao.EpisodeDao;
import jpa.models.EpisodeModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by fstancu on 5/22/2014.
 */

@Repository
public class EpisodeDaoImpl implements EpisodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EpisodeModel find(int episodeID) {
        return entityManager.find(EpisodeModel.class, episodeID);
    }

    @Override
    public void save(EpisodeModel toBeSaved) {
        entityManager.persist(toBeSaved);
    }

    @Override
    public void update(EpisodeModel toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    @Override
    public void remove(EpisodeModel toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }
}
