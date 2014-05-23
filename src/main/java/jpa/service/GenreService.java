package jpa.service;

import jpa.models.GenreModel;

/**
 * Created by fstancu on 5/22/2014.
 */
public interface GenreService {

    public GenreModel find(int genreID);

    public void save(GenreModel toBeSaved);

    public void update(GenreModel toBeUpdated);

    public void remove(GenreModel toBeRemoved);

}
