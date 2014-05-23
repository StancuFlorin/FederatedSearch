package jpa.service.impl;

import jpa.dao.GenreDao;
import jpa.models.GenreModel;
import jpa.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fstancu on 5/22/2014.
 */

@Service
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public GenreModel find(int genreID) {
        return genreDao.find(genreID);
    }

    @Override
    @Transactional
    public void save(GenreModel toBeSaved) {
        genreDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(GenreModel toBeUpdated) {
        genreDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(GenreModel toBeRemoved) {
        genreDao.remove(toBeRemoved);
    }
}
