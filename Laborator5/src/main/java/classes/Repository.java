package classes;

import repo.Document;
import repo.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Stream;
import java.nio.file.Path;
public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) throws IOException {
        this.directory = directory;
        loadDocuments();
    }



    public List<Document> loadPathDocuments(Path path) throws IOException
    {
        List<Document> result = new ArrayList<>();
        try(Stream<Path> stream = Files.walk(path)) {
            result = stream.filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .map(Document::new)
                    .toList();
        }
        return result;
    }
    private void loadDocuments() throws IOException
    {
        this.documents.clear();
        List<Path> subDirectories;
        try(Stream<Path> walk = Files.list(Paths.get(this.directory)))
        {
            subDirectories = walk.filter(Files::isDirectory).toList();
        }
        for(Path p : subDirectories)
        {
            String[] parts = p.getFileName().toString().split("_");
            var person = new Person(Integer.parseInt(parts[0]),parts[1]);
            List<Document> pathDocs = new ArrayList<>();
            pathDocs = loadPathDocuments(p);

            documents.put(person,pathDocs);
        }
    }

    public void addDocument(Person person, Document document) throws IOException
    {
        if (!documents.containsKey(person)) {
            throw new IllegalArgumentException("Person not found in documents map");
        }
        Path personDirectory = Paths.get(this.directory + "\\" + person.id() + "_" + person.name());
        Path filePath = personDirectory.resolve(document.file().getName());
        Files.copy(document.file().toPath(), filePath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File written successfully: " + filePath);

        loadDocuments();
    }
    public void addPerson(Person person) throws IOException
    {
        if(!documents.containsKey(person)){
            Path repoName = Paths.get(this.directory + "\\" + person.id() + "_" + person.name());
            try{
                Files.createDirectory(repoName);
                System.out.println("Directory created successfully!");
            } catch (IOException e) {
                System.err.println("Failed to create directory: " + e.getMessage());
            }
            loadDocuments();
        }
    }

    public void deletePerson(Person person) throws IOException
    {
        if(!documents.containsKey(person))
        {
            throw new IllegalArgumentException("Person doesn't exist: " + person.name());
        }
        Path directoryToDelete = Paths.get(this.directory + "\\" + person.id() + "_" + person.name());
        try{
            Files.delete(directoryToDelete);
            loadDocuments();
            System.out.println("Directory deleted successfully!");
        } catch (IOException e)
        {
            System.err.println("Failed to delete directory: " + e.getMessage());
        }
    }


    public void printAllDocuments()
    {
        for(Person person : documents.keySet())
        {
            System.out.println(person.name());
            for(Document document : documents.get(person))
                System.out.print(document.file().getName() + " ");
            System.out.println();
        }
    }
}