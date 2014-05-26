package jpa.dao.impl;

import jackson.imdb.Query;
import jpa.dao.QueryDao;
import jpa.models.QueryModel;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by fstancu on 5/26/2014.
 */

@Repository
public class QueryDaoImpl implements QueryDao {

    @PersistenceContext
    private EntityManager entityManager;

    private String QUERY_FIND_QUERY_BY_NAME = "Select q from QueryModel q where q.query = :query_name";

    @Override
    public QueryModel find(int queryID) {
        return entityManager.find(QueryModel.class, queryID);
    }

    @Override
    public QueryModel find(String queryName) {

        List queryModels = entityManager.createQuery(QUERY_FIND_QUERY_BY_NAME)
                            .setParameter("query_name", queryName)
                            .setMaxResults(1)
                            .getResultList();

        if ((queryModels != null) && (!queryModels.isEmpty()))
            return (QueryModel)queryModels.get(0);

        return null;

    }

    @Override
    public void save(QueryModel toBeSaved) {
        entityManager.persist(toBeSaved);
    }

    @Override
    public void update(QueryModel toBeUpdated) {
        entityManager.merge(toBeUpdated);
    }

    @Override
    public void remove(QueryModel toBeRemoved) {
        entityManager.remove(entityManager.merge(toBeRemoved));
    }

}
