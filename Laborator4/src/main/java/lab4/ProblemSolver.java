package lab4;

import org.jgrapht.Graph;
import org.jgrapht.alg.flow.EdmondsKarpMFImpl;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.List;

public class ProblemSolver {
    public int solve(List<Person> persons) {
        Graph<Person, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        for (Person person : persons) {
            graph.addVertex(person);
        }

        Person driver = null;
        Person pasager = null;

        for (Person person : persons) {
            if (person.isDriver(person)) {
                driver = person;
                for (Person otherPerson : persons) {
                    if (!otherPerson.isDriver(otherPerson) && otherPerson.getDestination().equals(person.getDestination())) {
                        graph.addEdge(person, otherPerson);
                        pasager = otherPerson;
                    }
                }
            }
        }

        if (driver == null || pasager == null) {
            throw new IllegalArgumentException("Source or target vertex not found");
        }

        EdmondsKarpMFImpl<Person, DefaultEdge> edmondsKarp = new EdmondsKarpMFImpl<>(graph);
        return (int) edmondsKarp.calculateMaximumFlow(driver, pasager);
    }
}