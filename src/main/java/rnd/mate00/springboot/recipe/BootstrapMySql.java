package rnd.mate00.springboot.recipe;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by mate00 on 18.11.17.
 */
@Component
@Profile({"dev"})
public class BootstrapMySql implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Loading bootstrap from DEV profile");
    }
}
