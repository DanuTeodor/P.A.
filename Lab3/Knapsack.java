package Lab3;

import java.util.*;

public class Knapsack {
    private double capacity;
    private List<Item> items;

    public Knapsack(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();

        description.append("capacity of the knapsack: " + capacity + "\n");
        description.append("available items(" + items.size() + "):\n");

        Collections.sort(items, new Comparator() {
                    public int compare(Object object1, Object object2) {
                        Item item1 = (Item) object1;
                        Item item2 = (Item) object2;
                        return item1.getName().compareTo(item2.getName());
                    }
                }
        );

        for (Item item : items) {
            if (item instanceof Book) {
                description.append("book: ");
            } else if (item instanceof Food) {
                description.append("food: ");
            } else if (item instanceof Weapon) {
                description.append("weapon: ");
            }

            description.append(item.getName() + ", weight = " + item.getWeight() + ", value = " + item.getValue() + " (profit factor = " + item.profitFactor() + ")\n");
        }

        return description.toString();
    }
}