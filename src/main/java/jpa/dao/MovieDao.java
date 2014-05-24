package jpa.dao;

import jpa.models.MovieModel;

/**
 * Created by fstancu on 5/22/2014.
 */

public interface MovieDao {

    public MovieModel find(int movieID);

    public void save(MovieModel toBeSaved);

    public void update(MovieModel toBeUpdated);

    public void remove(MovieModel toBeRemoved);

}
