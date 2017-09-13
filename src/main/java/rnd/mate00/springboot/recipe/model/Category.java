package rnd.mate00.springboot.recipe.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by mate00 on 13.09.17.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipies() {
        return recipies;
    }

    public void setRecipies(Set<Recipe> recipies) {
        this.recipies = recipies;
    }
}
