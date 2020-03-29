package lab2;

import java.util.Comparator;

public class SortByOrder implements Comparator<Client> {
    public int compare(Client client1, Client client2) {
        return client1.getOrder() - client2.getOrder();
    }
}
