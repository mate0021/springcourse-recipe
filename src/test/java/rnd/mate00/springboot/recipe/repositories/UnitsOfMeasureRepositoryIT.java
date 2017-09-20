package rnd.mate00.springboot.recipe.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import rnd.mate00.springboot.recipe.model.UnitOfMeasure;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.annotation.DirtiesContext.MethodMode.AFTER_METHOD;

/**
 * Created by mate00 on 20.09.17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitsOfMeasureRepositoryIT {

    @Autowired
    private UnitsOfMeasureRepository unitsOfMeasureRepository;

    @Before
    public void setUp() {}

    @Test
    @DirtiesContext(methodMode = AFTER_METHOD)
    public void testFindByName() {
        String name = "Teaspoon";
        Optional<UnitOfMeasure> all = unitsOfMeasureRepository.findByName(name);

        assertTrue(all.isPresent());
    }

    @Test
    public void testOther() {
        Optional<UnitOfMeasure> none = unitsOfMeasureRepository.findByName("xx");

        assertFalse(none.isPresent());
    }
}