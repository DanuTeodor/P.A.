package ServerApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private ServerSocket serverSocket;
    private final int PORT = 8100;

    public GameServer() {

        try {
            serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Waiting for a client...");

                Socket socket = serverSocket.accept();

                if (new ClientThread(socket).start()) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("error: " + e);
        }
    }
}
