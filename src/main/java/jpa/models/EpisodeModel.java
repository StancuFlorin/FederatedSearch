package jpa.models;

import javax.persistence.*;

/**
 * Created by fstancu on 5/22/2014.
 */
@Entity
@Table(name = "episodes")
public class EpisodeModel {

    @Id
    private int id;

    private int plays;
    private int season;
    private int number;
    private String title;
    private String url;

    @ManyToOne
    @JoinColumn(name="show")
    private ShowModel show;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

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

    public ShowModel getShow() {
        return show;
    }

    public void setShow(ShowModel show) {
        this.show = show;
    }
}
