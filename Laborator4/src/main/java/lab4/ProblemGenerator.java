// ProblemGenerator.java
package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProblemGenerator {
    private static final String[] DESTINATIONS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static final Random RANDOM = new Random();

    public List<Person> generate(int numDrivers, int numPassengers) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < numDrivers; i++) {
            String destination = DESTINATIONS[RANDOM.nextInt(DESTINATIONS.length)];
            persons.add(new Driver("Driver" + i, 30, destination));
        }

        for (int i = 0; i < numPassengers; i++) {
            String destination = DESTINATIONS[RANDOM.nextInt(DESTINATIONS.length)];
            persons.add(new Person("Passenger" + i, 30, destination));
        }

        return persons;
    }
}

