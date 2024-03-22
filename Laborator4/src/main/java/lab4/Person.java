package lab4;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String destination;
    private boolean isDriver;

    public Person(String name, int age, String destination, boolean isDriver) {
        this.name = name;
        this.age = age;
        this.destination = destination;
        this.isDriver = isDriver;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", destination='" + destination + '\'' +
                ", isDriver=" + isDriver +
                '}';
    }
}