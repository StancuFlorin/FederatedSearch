package jackson.tracktv;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by fstancu on 5/22/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actor {

    private String name;

    public Actor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
