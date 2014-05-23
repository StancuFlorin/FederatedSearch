package jpa.dao;

import jpa.models.ShowModel;

/**
 * Created by fstancu on 5/22/2014.
 */

public interface ShowDao {

    public ShowModel find(int showID);

    public void save(ShowModel toBeSaved);

    public void update(ShowModel toBeUpdated);

    public void remove(ShowModel toBeRemoved);

}
