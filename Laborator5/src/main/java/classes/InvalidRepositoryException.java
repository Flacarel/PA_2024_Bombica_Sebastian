package classes;

public class InvalidRepositoryException extends Exception {
    public InvalidRepositoryException(Exception ex) {
        super("Invalid repository.", ex);
    }
}