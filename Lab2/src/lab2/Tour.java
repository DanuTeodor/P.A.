package lab2;

import java.util.ArrayList;

public class Tour {
    private Vehicle vehicle;
    private ArrayList<Client> clients;

    public Tour() {
    }

    public Tour(Vehicle vehicle, ArrayList<Client> clients) {
        this.vehicle = vehicle;
        this.clients = clients;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }
}
