package jackson.tvrage;

import jpa.models.MovieModel;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clasa care mapeaza raspunsul dat de serverul "search-provider-with-callback".
 *
 * Created by Florin on 5/24/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {

    private String airtime;
    private String showid;
    private String status;
    private String runtime;
    private String airday;

    @JsonProperty("origin_country")
    private String originCountry;

    private String startdate;
    private String seasons;
    private String showname;
    private String started;

    private Network network;

    public Show() {}

    /**
     *
     * Transforma un obiect din aceasta clasa intr-un
     * obiect modelat pentru baza de date.
     *
     * @return
     * Obiectul care se mapeaza in baza de date.
     *
     */

    public MovieModel toJPAModel() {

        MovieModel movieModel = new MovieModel();

        movieModel.setAirTime(this.airtime);
        movieModel.setTvrageID(this.showid);
        movieModel.setStatus(this.status);
        movieModel.setRuntime(this.runtime);
        movieModel.setAirDay(this.airday);
        movieModel.setCountry(this.originCountry);
        movieModel.setReleased(this.startdate);
        movieModel.setTitle(this.showname);
        movieModel.setYear(this.started);

        return movieModel;

    }

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAirday() {
        return airday;
    }

    public void setAirday(String airday) {
        this.airday = airday;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
