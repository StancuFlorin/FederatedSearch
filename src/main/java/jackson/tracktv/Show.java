package jackson.tracktv;

import jpa.models.EpisodeModel;
import jpa.models.GenreModel;
import jpa.models.ShowModel;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Show {

    private String title;
    /*
    private int year;
    private String url;
/*
    private String country;
    private String overview;
    private String status;
    private String network;
    private String poster;
/*
    private List<String> genres;
    private People people;

    private String air_day;
    private String air_time;
    private String imdb_id;
    private String tvrage_id;

    private Collection<Episode> top_episodes;
*/
    public Show() {}

    /*
        TODO - adauga functionalitati pentru actors
     */

    public ShowModel toJPAModel() {

        ShowModel showModel = new ShowModel();
        showModel.setTitle(this.title);
        /*
        showModel.setYear(this.year);

        showModel.setUrl(this.url);
        showModel.setCountry(this.country);
        showModel.setOverview(this.overview);
        showModel.setStatus(this.status);
        showModel.setNetwork(this.network);
        showModel.setPoster(this.poster);

        showModel.setAirDay(this.air_day);
        showModel.setAirTime(this.air_time);
        showModel.setImdbID(this.imdb_id);
        showModel.setTvrageID(this.tvrage_id);

        Collection<GenreModel> genreModelCollection = new ArrayList<GenreModel>();
        for (String genre : this.genres) {

            GenreModel genreModel = new GenreModel();
            genreModel.setName(genre);
            genreModelCollection.add(genreModel);

        }

        //showModel.setGenres(genreModelCollection);

        Collection<EpisodeModel> episodeModelCollection = new ArrayList<EpisodeModel>();
        for (Episode episode : this.top_episodes) {

            EpisodeModel episodeModel = episode.toJPAModel();
            //episodeModel.setShow(showModel);
            episodeModelCollection.add(episodeModel);
            break;

        }

        //showModel.setEpisodes(episodeModelCollection);
*/
        return showModel;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
/*
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
/*
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
/*
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

    public Collection<Episode> getTop_episodes() {
        return top_episodes;
    }

    public void setTop_episodes(Collection<Episode> top_episodes) {
        this.top_episodes = top_episodes;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
*/
}
