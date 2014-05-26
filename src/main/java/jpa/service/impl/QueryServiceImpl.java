package jpa.service.impl;

import jpa.dao.QueryDao;
import jpa.models.QueryModel;
import jpa.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fstancu on 5/26/2014.
 */

@Service
@Transactional(readOnly = true)
public class QueryServiceImpl implements QueryService {

    @Autowired
    private QueryDao queryDao;

    @Override
    public QueryModel find(int queryID) {
        return queryDao.find(queryID);
    }

    @Override
    public QueryModel find(String queryName) {
        return queryDao.find(queryName);
    }

    @Override
    @Transactional
    public void save(QueryModel toBeSaved) {
        queryDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(QueryModel toBeUpdated) {
        queryDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(QueryModel toBeRemoved) {
        queryDao.remove(toBeRemoved);
    }
}
