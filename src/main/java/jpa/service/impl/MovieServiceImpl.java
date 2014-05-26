package jpa.service.impl;

import jpa.dao.MovieDao;
import jpa.models.MovieModel;
import jpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fstancu on 5/22/2014.
 */

@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public MovieModel find(int movieID) {
        return movieDao.find(movieID);
    }

    @Override
    @Transactional
    public void save(MovieModel toBeSaved) {
        movieDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(MovieModel toBeUpdated) {
        movieDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(MovieModel toBeRemoved) {
        movieDao.remove(toBeRemoved);
    }
}
