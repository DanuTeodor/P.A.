package ClientApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    private String serverAddress = "127.0.0.1";
    private final int PORT = 8100;

    public GameClient() {
        try {
            Socket socket = new Socket(serverAddress, PORT);

            while (true) {
                System.out.print("command: ");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                String request = reader.readLine();

                if (request.equals("exit")) {
                    out.println(request);
                    break;
                } else {
                    out.println(request);
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }
}
