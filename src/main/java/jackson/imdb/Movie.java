package jackson.imdb;

import jpa.models.MovieModel;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * Clasa care mapteaza un obiect de tip "Movie" primit in raspunsul
 * dat de serverul "search-provider-with-pooling".
 *
 * Created by fstancu on 5/23/2014.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Released")
    private String peleased;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Writer")
    private String writer;

    public Movie() {}

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
        movieModel.setYear(this.year);
        movieModel.setCountry(this.country);
        movieModel.setGenre(this.genre);
        movieModel.setImdbID(this.imdbID);
        movieModel.setImdbRating(this.imdbRating);
        movieModel.setImdbVotes(this.imdbVotes);
        movieModel.setLanguage(this.language);
        movieModel.setPlot(this.plot);
        movieModel.setPoster(this.poster);
        movieModel.setRated(this.rated);
        movieModel.setRuntime(this.runtime);

        return movieModel;

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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getPeleased() {
        return peleased;
    }

    public void setPeleased(String peleased) {
        this.peleased = peleased;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
