package Lab3;

public class Food implements Item {
    private String name;
    private double weight; // → getWeight, getValue

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return weight * 2;
    }

    public double getWeight()    {
        return weight;
    }
}