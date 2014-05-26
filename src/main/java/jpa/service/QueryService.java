package jpa.service;

import jackson.imdb.Query;
import jpa.models.QueryModel;

import java.util.List;

/**
 * Created by fstancu on 5/26/2014.
 */
public interface QueryService {

    public QueryModel find(int queryID);

    public QueryModel find(String queryName);

    public void save(QueryModel toBeSaved);

    public void update(QueryModel toBeUpdated);

    public void remove(QueryModel toBeRemoved);

}
