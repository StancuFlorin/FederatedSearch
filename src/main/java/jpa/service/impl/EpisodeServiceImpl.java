package jpa.service.impl;

import jpa.dao.EpisodeDao;
import jpa.models.EpisodeModel;
import jpa.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fstancu on 5/22/2014.
 */

@Service
@Transactional(readOnly = true)
public class EpisodeServiceImpl implements EpisodeService {

    @Autowired
    private EpisodeDao episodeDao;

    @Override
    public EpisodeModel find(int episodeID) {
        return episodeDao.find(episodeID);
    }

    @Override
    @Transactional
    public void save(EpisodeModel toBeSaved) {
        episodeDao.save(toBeSaved);
    }

    @Override
    @Transactional
    public void update(EpisodeModel toBeUpdated) {
        episodeDao.update(toBeUpdated);
    }

    @Override
    @Transactional
    public void remove(EpisodeModel toBeRemoved) {
        episodeDao.remove(toBeRemoved);
    }
}
