package jackson.tracktv;

import jpa.models.EpisodeModel;
import jpa.models.MovieModel;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa care mapeaza un serial din raspunsul dat
 * de serverul "syncwebserver".
 *
 * Created by fstancu on 5/22/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {

    private String title;

    private int year;
    private String url;

    private String country;
    private String overview;
    private String status;
    private String network;
    private String poster;

    private List<String> genres;
    private People people;

    private String air_day;
    private String air_time;
    private String imdb_id;
    private String tvrage_id;

    private List<Episode> top_episodes;

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

        movieModel.setTitle(this.title);
        movieModel.setYear(this.year + "");
        movieModel.setTrackTVURL(this.url);
        movieModel.setCountry(this.country);
        movieModel.setPlot(this.overview);
        movieModel.setStatus(this.status);
        movieModel.setNetwork(this.network);
        movieModel.setPoster(this.poster);

        StringBuilder stringBuilderGenres = new StringBuilder();
        for (String genre : this.genres) {
            stringBuilderGenres.append(genre);
            stringBuilderGenres.append(", ");
        }
        if (stringBuilderGenres.length() != 0)
            stringBuilderGenres.setLength(stringBuilderGenres.length() - 2);
        movieModel.setGenre(stringBuilderGenres.toString());

        List<EpisodeModel> episodeModelSet = new ArrayList<EpisodeModel>();
        for (Episode episode : this.top_episodes) {
            episodeModelSet.add(episode.toJPAModel());
        }

        movieModel.setEpisodes(episodeModelSet);

        movieModel.setAirDay(this.air_day);
        movieModel.setAirTime(this.air_time);
        movieModel.setImdbID(this.imdb_id);
        movieModel.setTvrageID(this.tvrage_id);

        return movieModel;

    }

    public Show() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getAir_day() {
        return air_day;
    }

    public void setAir_day(String air_day) {
        this.air_day = air_day;
    }

    public String getAir_time() {
        return air_time;
    }

    public void setAir_time(String air_time) {
        this.air_time = air_time;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTvrage_id() {
        return tvrage_id;
    }

    public void setTvrage_id(String tvrage_id) {
        this.tvrage_id = tvrage_id;
    }

    public List<Episode> getTop_episodes() {
        return top_episodes;
    }

    public void setTop_episodes(List<Episode> top_episodes) {
        this.top_episodes = top_episodes;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

}
