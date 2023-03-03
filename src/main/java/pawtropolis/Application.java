package pawtropolis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawtropolis.game.GameController;

@SpringBootApplication
public class Application implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        GameController.getInstance().runGame();
    }
}