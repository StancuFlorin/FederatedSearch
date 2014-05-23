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

    public List<ShowModel> toJPAModel() {

        List<ShowModel> showModelList = new ArrayList<ShowModel>();

        for (Show show : content) {
            showModelList.add(show.toJPAModel());
        }

        return showModelList;

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
