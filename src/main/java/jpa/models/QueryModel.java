package jpa.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by fstancu on 5/26/2014.
 */

@Entity
@Table(name = "queries", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class QueryModel {

    @Id
    private int id;

    private String query;

    private Date date;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "queries_has_movies", joinColumns={@JoinColumn(name="query", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="movie", referencedColumnName="id")})
    private List<MovieModel> movies;

    public QueryModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
