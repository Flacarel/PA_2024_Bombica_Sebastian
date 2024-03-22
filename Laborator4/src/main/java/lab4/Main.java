package lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.compulsory();
    }

    public void compulsory() {
        List<Person> persons = generateRandomPersons(10);
        LinkedList<Person> drivers = persons.stream()
                .filter(Person::isDriver)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));
        TreeSet<Person> passengers = persons.stream()
                .filter(p -> !p.isDriver())
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("Drivers sorted by age:");
        drivers.forEach(System.out::println);

        System.out.println("Passengers sorted by name:");
        passengers.forEach(System.out::println);
    }

    private List<Person> generateRandomPersons(int numPersons) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPersons; i++) {
            String name = "Person " + (i + 1);
            int age = random.nextInt(100);
            String destination = "Destination " + (i + 1);
            boolean isDriver = random.nextBoolean();
            persons.add(new Person(name, age, destination, isDriver));
        }
        return persons;
    }
}