package rnd.mate00.springboot.recipe.commands;

/**
 * Created by mate00 on 28.09.17.
 */
public class UnitOfMeasureCommand {

    private long id;
    private String name;

    public UnitOfMeasureCommand() {
    }

    public UnitOfMeasureCommand(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
