package lab2;

import java.util.Map;

public class Problem {
    private Depot[] depots;
    private Client[] clients;

    public Problem() {
    }

    public Problem(Depot[] depots, Client[] clients) {
        setDepots(depots);
        setClients(clients);
    }

    public void setDepots(Depot[] depots) {
        Map<String, Boolean> MapDepots = new Map<String, Boolean>();
        for (Depot depot : depots) {
            if (MapDepots.get(depot.getName()) != null) {
                System.out.println("Nu se poate insersa un depou de 2 ori.");
                return;
            }
            MapDepots.put(depot.getName(), true);
        }
        this.depots = depots;
    }

    public Depot[] getDepots() {
        return depots;
    }

    public void setClients(Client[] clients) {
        Map<String, Boolean> MapClients = new Map<String, Boolean>();
        for (Client client : clients) {
            if (MapClients.get(client.getName()) != null) {
                System.out.println("Attempt to insert a client depot denied.");
                return;
            }
            MapClients.put(client.getName(), true);
        }
        this.clients = clients;
    }

    public Client[] getClients() {
        return clients;
    }

    @Override
    public String toString() {
        StringBuilder problemDescription = new StringBuilder();

        problemDescription.append("There are " + depots.length + " depots: ");
        for (Depot depot : depots) {
            problemDescription.append(depot + ", ");
        }
        problemDescription.append("\n");

        for (Depot depot : depots) {
            problemDescription.append(depot + " has " + depot.getVehicles().length + " vehicle(s): ");
            for (Vehicle vehicle : depot.getVehicles()) {
                problemDescription.append(vehicle + ", ");
            }
            problemDescription.append("\n");
        }

        problemDescription.append("There are " + clients.length + " clients: ");
        for (Client client : clients) {
            problemDescription.append(client + "(" + client.getOrder() + "), ");
        }
        problemDescription.append("\n");

        return problemDescription.toString();
    }
}
