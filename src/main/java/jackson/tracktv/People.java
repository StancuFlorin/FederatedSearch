package jackson.tracktv;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class People {

    private List<Actor> actors;

    public People() {}

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
