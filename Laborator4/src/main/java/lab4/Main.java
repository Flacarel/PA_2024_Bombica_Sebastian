package lab4;

import java.util.*;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//    main.compulsory();
        main.homework();
        main.bonus();
    }

    public void compulsory() {
        List<Person> group = generateRandomPersons(10);

        List<Person> drivers = group.stream()
                .filter(person -> person instanceof Driver)
                .collect(Collectors.toList());

        List<Person> passengers = group.stream()
                .filter(person -> person instanceof Person && !(person instanceof Driver))
                .collect(Collectors.toList());
        for (Person driver : drivers) {
            System.out.println(driver);
        }
        for (Person passenger : passengers) {
            System.out.println(passenger);
        }
        System.out.println();
        LinkedList<Person> driversLinkedList = new LinkedList<>(drivers);
        Collections.sort(driversLinkedList, Comparator.comparingInt(Person::getAge));
        for (Person driver : driversLinkedList) {
            System.out.println(driver);
        }
        TreeSet<Person> passengersTreeSet = new TreeSet<>(Comparator.comparing(Person::getName));
        passengersTreeSet.addAll(passengers);
        for (Person passenger : passengersTreeSet) {
            System.out.println(passenger);
        }

    }

    public List<Person> generateRandomPersons(int numberOfPersons) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfPersons; i++) {
            String name = "Person" + i;
            int age = random.nextInt(100);
            int indexDestination = random.nextInt(numberOfPersons - 1);
            String destination = "Destination" + indexDestination;

            if (random.nextBoolean()) {
                persons.add(new Person(name, age, destination));
            } else {
                persons.add(new Driver(name, age, destination));
            }
        }

        return persons;
    }

    RoadMap generateRoadMap(int numberOfRoads, int numberOfStops) {
        Faker faker = new Faker();
        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < numberOfRoads; i++) {
            List<String> stops = new ArrayList<>();
            for (int j = 0; j < numberOfStops; j++) {
                stops.add(faker.address().city());
            }
            roads.add(new Road(stops));
        }
        return new RoadMap(roads);
    }

    List<Person> generateRandomPersons(int numberOfPersons, RoadMap roadMap) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();
        for (int i = 0; i < numberOfPersons; i++) {
            String name = faker.name().fullName();
            int age = random.nextInt(100);
            List<Road> roads = roadMap.getRoads();

            int roadIndex = random.nextInt(roads.size());

            Road road = roads.get(roadIndex);

            List<String> stops = road.getStops();

            int stopIndex = random.nextInt(stops.size());

            String destination = stops.get(stopIndex);
            if (random.nextBoolean()) {
                persons.add(new Person(name, age, destination));
            } else {
                persons.add(new Driver(name, age, destination));
            }
        }
        return persons;
    }

    public void homework() {
        Problem problem = new Problem();
        RoadMap roadMap = generateRoadMap(10, 10);
        problem.setRoadMap(roadMap);
        problem.setPersons(generateRandomPersons(5000, roadMap));
        problem.findDestinationsOfDrivers();
        problem.findDestinationsOfPersons();
        problem.matching();
        // problem.printDriverAndPassenger();
        System.out.println(roadMap);
    }

    public void bonus() {
        ProblemGenerator generator = new ProblemGenerator();
        List<Person> persons = generator.generate(2500, 2500);
        Graph<Person, DefaultEdge> graph = new SimpleDirectedGraph<>(DefaultEdge.class);
        for (Person person : persons) {
            graph.addVertex(person);
        }
        for (Person driver : persons) {
            if (driver.isDriver(driver)) {
                for (Person passenger : persons) {
                    if (!passenger.isDriver(passenger) && Math.random() < 0.1) {
                        graph.addEdge(driver, passenger);
                    }
                }
            }
        }
        ProblemSolver solver = new ProblemSolver();
        int maxFlow = solver.solve(persons);
        System.out.println("Matchings: " + maxFlow);
    }
}

