package classes;

import repo.Document;
import repo.Person;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository repo = new Repository("C:\\Users\\bombi\\OneDrive\\Desktop\\facultate\\Programare_avansata\\Laborator5\\fisier");
        repo.printAllDocuments();
        var person = new Person(3,"CaZaN");
        repo.addPerson(person);
        File file = new File("C:\\Users\\bombi\\OneDrive\\Desktop\\1108129.jpg");
        Document document = new Document(file);
        repo.addDocument(person,document);
        repo.printAllDocuments();

    }
}
