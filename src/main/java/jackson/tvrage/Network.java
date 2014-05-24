package jackson.tvrage;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Florin on 5/24/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    private String content;
    private String country;

    public Network() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
