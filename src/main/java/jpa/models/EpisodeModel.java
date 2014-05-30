package jpa.models;

import javax.persistence.*;

/**
 * Created by fstancu on 5/30/2014.
 */
@Entity
@Table(name = "episodes", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class EpisodeModel {

    @Id
    @GeneratedValue
    private int id;

    private int season;
    private int plays;
    private int number;
    private String title;
    private String url;

    public EpisodeModel() {}

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
