package jpa.models;

import javax.persistence.*;

@Entity
@Table(name = "movies", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class MovieModel {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String year;
    private String country;
    private String genre;
    private String language;
    private String poster;
    private String released;
    private String runtime;
    private String status;
    private String network;

    private String plot;
    private String rated;
    @Column(name = "air_day")
    private String airDay;
    @Column(name = "air_time")
    private String airTime;
    @Column(name = "imdb_id")
    private String imdbID;
    @Column(name = "tracktv_url")
    private String trackTVURL;
    @Column(name = "tvrage_id")
    private String tvrageID;
    @Column(name = "imdb_rating")
    private String imdbRating;
    @Column(name = "imdb_votes")
    private String imdbVotes;

    public MovieModel() {}

    public void merge(MovieModel movieModel) {

        if (this.country == null)
            this.country = movieModel.getCountry();

        if (this.genre == null)
            this.genre = movieModel.getGenre();

        if (this.language == null)
            this.language = movieModel.getLanguage();

        if (this.poster == null)
            this.poster = movieModel.getPoster();

        if (this.released == null)
            this.released = movieModel.getReleased();

        if (this.runtime == null)
            this.runtime = movieModel.getRuntime();

        if (this.status == null)
            this.status = movieModel.getStatus();

        if (this.network == null)
            this.network = movieModel.getNetwork();

        if (this.rated == null)
            this.rated = movieModel.getRated();

        if (this.airDay == null)
            this.airDay = movieModel.getAirDay();

        if (this.airTime == null)
            this.airTime = movieModel.getAirTime();

        if (this.trackTVURL == null)
            this.trackTVURL = movieModel.getTrackTVURL();

        if (this.tvrageID == null)
            this.tvrageID = movieModel.getTvrageID();

        if (this.imdbRating == null)
            this.imdbRating = movieModel.getImdbRating();

        if (this.imdbVotes == null)
            this.imdbVotes = movieModel.getImdbVotes();

    }

    @Override
    public boolean equals(Object other){

        if (other == null) return false;
        if (other == this) return true;

        if (!(other instanceof MovieModel))return false;

        MovieModel otherMovieModel = (MovieModel)other;

        if (this.imdbID != null) {
            if (this.imdbID.equals(otherMovieModel.getImdbID()))
                return true;
        }

        if (this.tvrageID != null) {
            if (this.tvrageID.equals(otherMovieModel.getTvrageID()))
                return true;
        }

        if (this.title != null) {
            if (this.title.equals(otherMovieModel.getTitle()))
                return true;
        }

        return false;

    }

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
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

    public String getTrackTVURL() {
        return trackTVURL;
    }

    public void setTrackTVURL(String trackTVURL) {
        this.trackTVURL = trackTVURL;
    }

    public String getTvrageID() {
        return tvrageID;
    }

    public void setTvrageID(String tvrageID) {
        this.tvrageID = tvrageID;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

}