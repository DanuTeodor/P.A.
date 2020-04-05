package Lab7;

public class Main {

    public static void main(String[] args) {
        if(args.length != 4){
            System.out.println("Error: not enough arguments or to many arguments");
        }
        else {
            Game game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));

            game.Start();
            game.ShowResults();
        }
    }
}
