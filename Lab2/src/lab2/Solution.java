package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private ArrayList<Tour> tours = new ArrayList<Tour>();

    public void solve(Problem problem) {
        Depot[] depots = problem.getDepots();
        Client[] clients = problem.getClients();

        Arrays.sort(clients, new SortByOrder()); // orders clients by priority

        HashMap<String, Boolean> visitedClients = new HashMap<String, Boolean>();

        for (Depot depot : depots) { // greedy algorithm to allocate trips to vehicles
            Vehicle[] vehicles = depot.getVehicles();

            for (Vehicle vehicle : vehicles) {
                Tour tour = new Tour();
                ArrayList<Client> clientsVisited = new ArrayList<Client>();

                tour.setVehicle(vehicle);

                boolean wasUsed = false;
                int time = -1;

                for (Client client : clients) {
                    if (client.getOrder() != time && visitedClients.containsKey(client.toString()) == false) { // client not visited -> visit
                        clientsVisited.add(client);
                        visitedClients.put(client.toString(), true);

                        wasUsed = true;
                        time = client.getOrder();
                    }
                }

                if(wasUsed == true) {
                    tour.setClients(clientsVisited);
                    tours.add(tour);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder solutionDescription = new StringBuilder();

        if(tours.isEmpty() == true) {
            solutionDescription.append("Greedy method failed to allocate any trips.");
        }
        else {
            for(Tour tour : tours) {
                solutionDescription.append(tour.getVehicle() + ": " + tour.getVehicle().getDepot() + " - ");

                for(Client client : tour.getClients()) {
                    solutionDescription.append(client + " - ");
                }

                solutionDescription.append(tour.getVehicle().getDepot() + "\n");
            }
        }

        return solutionDescription.toString();
    }
}
