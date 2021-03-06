import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server
{


public static Connection[] connections;

  public static void startServer(int port, int max_user)
  {
    System.out.println("Starting server on port " + port + " ...");

    connections= new Connection[max_user];

    try
    {
      // The server socket
      ServerSocket servSock = new ServerSocket(port);

      int connectionCount = 0;
      while (true)
      {
        System.out.println("Waiting for a connection...");

        // Incoming client socket
        Socket clientSock = servSock.accept();

        System.out.println("Connection received, setting up data structures...");

        Connection connection = new Connection(clientSock);

        connections[connectionCount++] = connection;

        System.out.println("Connection object created.");
      }

    }
    catch (IOException err)
    {
      System.out.println("There was an error with the server socket.");

    }
  }

}
