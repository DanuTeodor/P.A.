package lab2;

public class Main {
    public static void main(String[] args) {
        compulsory();
    }

    public static Problem compulsory() {
        System.out.println("Compulsory:\n");
        Client[] clients = {
                new Client("C1", 1),
                new Client("C2", 1),
                new Client("C3", 2),
                new Client("C4", 2),
                new Client("C5", 3)
        };

        Vehicle[] vehicles = {
                new Car("V1"),
                new Truck("V2"),
                new Drone("V3")
        };

        Depot[] depots = {
                new Depot("D1", new Vehicle[]{vehicles[0], vehicles[1]}),
                new Depot("D2", new Vehicle[]{vehicles[2]})
        };

        Problem problem = new Problem(depots, clients);

        System.out.println(problem);

        return problem;
    }

}