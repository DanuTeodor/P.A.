package Lab3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        compulsory();
    }

    public static void compulsory() {
        Item weapon = new Weapon(WeaponType.SWORD, 5, 10);
        Item book1 = new Book("Dragon Rising", 3, 5);
        Item book2 = new Book("A Blade in the Dark", 3, 5);

        Item food1 = new Food("Cabbage", 2);
        Item food2 = new Food("Rabbit", 2);



        Knapsack knapsack = new Knapsack(10);
        knapsack.addItem(book1);
        knapsack.addItem(book2);
        knapsack.addItem(food1);
        knapsack.addItem(food2);
        knapsack.addItem(weapon);

        System.out.println(knapsack);
    }


}
