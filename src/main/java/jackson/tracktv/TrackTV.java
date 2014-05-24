package jackson.tracktv;

import jpa.models.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackTV {

    private int noEntries;
    private List<Show> content;

    public TrackTV() {}

    public List<MovieModel> toJPAModel() {

        List<MovieModel> movieModelList = new ArrayList<MovieModel>();
        for (Show show : this.content)
            movieModelList.add(show.toJPAModel());

        return movieModelList;

    }

    public int getNoEntries() {
        return noEntries;
    }

    public void setNoEntries(int noEntries) {
        this.noEntries = noEntries;
    }

    public List<Show> getContent() {
        return content;
    }

    public void setContent(List<Show> content) {
        this.content = content;
    }

}
