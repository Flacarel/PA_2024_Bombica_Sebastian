package lab4;

public class Driver extends Person{
    Person passenger;

    public Driver(String name, int age, String destination, boolean isDriver) {
        super(name, age, destination, isDriver);
    }

    public void setPassenger(Person passenger) {
        this.passenger = new Person( passenger.getName(), passenger.getAge(), passenger.getDestination(), passenger.isDriver() );
    }

    public Person getPassenger() {
        return passenger;
    }
}