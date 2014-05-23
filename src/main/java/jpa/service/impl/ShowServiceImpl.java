package jpa.service.impl;

import jpa.dao.ShowDao;
import jpa.models.ShowModel;
import jpa.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fstancu on 5/22/2014.
 */

@Service
@Transactional(readOnly = true)
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowDao showDao;

    @Override
    public ShowModel find(int showID) {
        return showDao.find(showID);
    }

    @Override
    @Transactional
    public void save(ShowModel toBeSaved) {
        showDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(ShowModel toBeUpdated) {
        showDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(ShowModel toBeRemoved) {
        showDao.remove(toBeRemoved);
    }
}
