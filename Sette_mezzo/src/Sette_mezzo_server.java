import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

class Server extends Thread {

	Socket socket;

	public Server(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		System.out.println("New client connected");
		try (
				// Estraggo il canale di ingresso
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));

				// Estraggo il canale di uscita
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true)) {

			// Inizio a leggere e a scrivere finché non mi arriva la stringa "bye"
			writer.println("Server in ascolto scrivere esci per uscire scrivi ok per continuare");
			String text;
			while ((text = reader.readLine()) != null) {
				
				Partita_sm giocata = new Partita_sm(writer,reader);
				 
				giocata.menu();
				// Echo the received message
				//invio dati al server
//				writer.println();

				// Exit condition
				if ("esci".equalsIgnoreCase(text)) {
					System.out.println("Client disconnected");
					break;
				}
			}

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}

public class Sette_mezzo_server {
	public void Server(int port) {
		// int port = 12345; // Port number

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			// Creo il socket sul quale sarò in "ascolto"
			System.out.println("Server is listening on port " + port);

			while (true) {
				// resta in attesa finché un "client" chiederà di collegarsi
				Socket socket = serverSocket.accept();
				System.out.println("New client connected");
				
				System.out.println("ciao");
				// creo client su trread
				Server srv = new Server(socket);

				srv.start();
			}

		} catch (

		IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}