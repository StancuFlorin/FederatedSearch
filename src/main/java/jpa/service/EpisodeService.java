package jpa.service;

import jpa.models.EpisodeModel;

/**
 * Created by fstancu on 5/22/2014.
 */

public interface EpisodeService {

    public EpisodeModel find(int episodeID);

    public void save(EpisodeModel toBeSaved);

    public void update(EpisodeModel toBeUpdated);

    public void remove(EpisodeModel toBeRemoved);

}
