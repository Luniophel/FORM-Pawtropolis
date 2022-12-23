package pawtropolis;

import pawtropolis.animals.ZooController;
import pawtropolis.animals.domain.*;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        // de-commentare per testare tutte le funzionalità della classe ZooController
        // testZoo();
    }

    private static void testZoo() {
        ZooController zooController = new ZooController();

        zooController.addAnimal(new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5));
        zooController.addAnimal(new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13, 0.7, 0.9));
        zooController.addAnimal(new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8, 1.1, 6.21));

        zooController.addAnimal(new Tiger("Man", "pizza", 30, LocalDate.now(), 80, 1.8, 0.3));
        zooController.addAnimal(new Tiger("Tigro", "miele", 8, LocalDate.now(), 20, 1, 0.7));
        zooController.addAnimal(new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70, 1.7, 1));

        zooController.addAnimal(new Eagle("Piccione", "pane", 1, LocalDate.now(), 1, 0.2, 0.3));
        zooController.addAnimal(new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2, 0.3, 0.5));
        zooController.addAnimal(new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30, 1, 2));

        AnimalWithTail animalWithLongestTail = zooController.getAnimalWithLongestTail();
        System.out.println("Animal with longest tail: " + animalWithLongestTail.getName());

        AnimalWithWings animalWithWidestWingspan = zooController.getAnimalWithWidestWingspan();
        System.out.println("Animal with widest wingspan: " + animalWithWidestWingspan.getName());

        Tiger tallestTiger = zooController.getTallestAnimalByClass(Tiger.class);
        System.out.println("Tallest tiger: " + tallestTiger.getName());

        Tiger shortestTiger = zooController.getShortestAnimalByClass(Tiger.class);
        System.out.println("Shortest tiger: " + shortestTiger.getName());

        Lion tallestLion = zooController.getTallestAnimalByClass(Lion.class);
        System.out.println("Tallest lion: " + tallestLion.getName());

        Lion shortestLion = zooController.getShortestAnimalByClass(Lion.class);
        System.out.println("Shortest lion: " + shortestLion.getName());

        Eagle tallestEagle = zooController.getTallestAnimalByClass(Eagle.class);
        System.out.println("Tallest eagle: " + tallestEagle.getName());

        Eagle shortestEagle = zooController.getShortestAnimalByClass(Eagle.class);
        System.out.println("Shortest eagle: " + shortestEagle.getName());

        Tiger heaviestTiger = zooController.getHeaviestAnimalByClass(Tiger.class);
        System.out.println("Heaviest tiger: " + heaviestTiger.getName());

        Tiger lightestTiger = zooController.getLightestAnimalByClass(Tiger.class);
        System.out.println("Lightest tiger: " + lightestTiger.getName());

        Lion heaviestLion = zooController.getHeaviestAnimalByClass(Lion.class);
        System.out.println("Heaviest lion: " + heaviestLion.getName());

        Lion lightestLion = zooController.getLightestAnimalByClass(Lion.class);
        System.out.println("Lightest lion: " + lightestLion.getName());

        Eagle heaviestEagle = zooController.getHeaviestAnimalByClass(Eagle.class);
        System.out.println("Heaviest eagle: " + heaviestEagle.getName());

        Eagle lightestEagle = zooController.getLightestAnimalByClass(Eagle.class);
        System.out.println("Lightest eagle: " + lightestEagle.getName());
    }
}