package rnd.mate00.springboot.recipe.commands;

/**
 * Created by mate00 on 29.09.17.
 */
public class NotesCommand {

    private long id;

//    private RecipeCommand recipe;

    private String recipeNotes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
