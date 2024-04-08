package classes;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //     main.compulsory();
        main.homework();
    }

    public void compulsory() {
        try {
            Repository repo = new Repository("../fisier");
            var person = new Person(101, "B");
            repo.addPerson(person);
            repo.printAllDocuments();
            File file = new File("../fisier/1_eu/terog.txt");
            Document document = new Document(file);
            repo.addDocument(person, document);
            repo.printAllDocuments();
            repo.deletePerson(person);
            repo.printAllDocuments();
        } catch (InvalidRepositoryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void homework() {
        try {
            Repository repo = new Repository("../fisier");
            CommandReader commandReader = new CommandReader(repo);
            commandReader.readAndExecute();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}