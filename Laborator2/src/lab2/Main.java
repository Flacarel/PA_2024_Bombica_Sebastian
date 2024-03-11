package lab2;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Main lab2 = new Main();
        lab2.homework();

    }
    public void homework() {
        Client client1 = new Client("Client1", LocalTime.of(8, 0), LocalTime.of(22, 0), Client.Type.REGULAR);
        Client client2 = new Client("Client2", LocalTime.of(15, 20), LocalTime.of(17, 15), Client.Type.REGULAR);
        Client client3 = new Client("Client3", LocalTime.of(10, 40), LocalTime.of(12, 30), Client.Type.PREMIUM);
        Client client4 = new Client("Client4", LocalTime.of(17, 0), LocalTime.of(21, 10), Client.Type.REGULAR);
        Vehicle vehicle1 = new Truck("Truck1", 100);
        Vehicle vehicle2 = new Drone("Drone1", 50);
        Vehicle vehicle3 = new Truck("Truck2", 150);
        Depot depot1 = new Depot("Depot1");
        depot1.setVehicles(vehicle1);
        Depot depot2 = new Depot("Depot2");
        depot2.setVehicles(vehicle2, vehicle3);
        Problem problem = new Problem();
        problem.setDepots(depot1, depot2);
        problem.setClients(client1, client2, client3, client4);
        Solution solution = new Solution(problem);
        solution.solveHomework(solution.getProblem());
    }

    public void bonus() {

    }
}
