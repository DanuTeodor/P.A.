package ServerApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public boolean start() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response;

                System.out.println(request);

                if (request.equals("exit")) {
                    break;
                } else if (request.equals("stop")) {
                    response = "Server stopped";

                    out.println(response);
                    out.flush();

                    return true;
                } else {
                    response = "Server received the request ...";

                    out.println(response);
                    out.flush();
                }
            }

            return false;
        } catch (IOException e) {
            System.err.println("error: " + e);
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("error: " + e);
            }
        }
    }
}
