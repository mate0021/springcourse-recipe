package rnd.mate00.springboot.recipe.commands;

import java.util.Set;

/**
 * Created by mate00 on 28.09.17.
 */
public class CategoryCommand {

    private long id;
    private String description;
    private Set<RecipeCommand> recipies;

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

    public Set<RecipeCommand> getRecipies() {
        return recipies;
    }

    public void setRecipies(Set<RecipeCommand> recipies) {
        this.recipies = recipies;
    }
}
