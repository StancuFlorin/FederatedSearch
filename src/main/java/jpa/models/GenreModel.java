package jpa.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * Created by fstancu on 5/22/2014.
 */
@Entity
@Table(name = "genres")
public class GenreModel {

    @Id
    private int id;

    private String name;

    @ManyToMany (mappedBy = "genres")
    private Collection<ShowModel> shows;

    public GenreModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
