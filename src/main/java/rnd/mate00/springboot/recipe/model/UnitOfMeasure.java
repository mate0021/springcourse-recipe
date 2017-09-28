package rnd.mate00.springboot.recipe.model;

import javax.persistence.*;

/**
 * Created by mate00 on 12.09.17.
 */
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(long id, String name) {
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

    @Override
    public String toString() {
        return "UnitOfMeasure{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
