package jackson.imdb;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Clasa care mapeaza raspunsul dat de serverul "search-provider-with-pooling".
 * Avem nevoie de ea pentru a extrage adresa la care se gaseste raspunsul.
 *
 * Created by fstancu on 5/23/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {

    private String message;
    private String detail;

    public Query() {}

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
