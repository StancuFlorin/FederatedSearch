package jpa.models;

import jackson.tracktv.Episode;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by fstancu on 5/22/2014.
 */

@Entity
@Table(name = "shows")
public class ShowModel {

    @Id
    private int id;

    private String title;
    private int year;
    private String url;

    private String country;
    private String overview;
    private String status;
    private String network;
    private String poster;

    @OneToMany(mappedBy = "show", cascade = CascadeType.PERSIST)
    private Collection<EpisodeModel> episodes;

    @ManyToMany
    private Collection<GenreModel> genres;

    @Column(name = "air_day")
    private String airDay;

    @Column(name = "air_time")
    private String airTime;

    @Column(name = "imdb_id")
    private String imdbID;

    @Column(name = "tvrage_id")
    private String tvrageID;

    public ShowModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getAirDay() {
        return airDay;
    }

    public void setAirDay(String airDay) {
        this.airDay = airDay;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTvrageID() {
        return tvrageID;
    }

    public void setTvrageID(String tvrageID) {
        this.tvrageID = tvrageID;
    }

    public Collection<GenreModel> getGenres() {
        return genres;
    }

    public void setGenres(Collection<GenreModel> genres) {
        this.genres = genres;
    }

    public Collection<EpisodeModel> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Collection<EpisodeModel> episodes) {
        this.episodes = episodes;
    }
}
