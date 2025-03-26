
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWeb {
	 int port = 8080;
	public void Server() {
		// int port = 8080; // Port number

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			// Creo il socket sul quale sarò in "ascolto"
			System.out.println("Server is listening on port " + port);

			// resta in attesa finché un "client" chiederà di collegarsi
			Socket socket = serverSocket.accept();
			System.out.println("New client connected");

			// Handle client in a separate thread
			try (
					// Estraggo il canale di ingresso
					InputStream input = socket.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(input));

					// Estraggo il canale di uscita
					OutputStream output = socket.getOutputStream();
					PrintWriter writer = new PrintWriter(output, true)) {

				// Inizio a leggere e a scrivere finché non mi arriva la stringa "bye"
				String text;
				while ((text = reader.readLine()) != null) {
					System.out.println("Received: " + text);

					// Echo the received message
					writer.println("Server: " + text);

					// Exit condition
					//"bye".equalsIgnoreCase(text)
					if (text.length() == 0) {
						System.out.println("Client disconnected");
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println("Server exception: " + ex.getMessage());
				ex.printStackTrace();
			}

		} catch (

		IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
