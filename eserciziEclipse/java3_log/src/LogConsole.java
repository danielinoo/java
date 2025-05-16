import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogConsole {

	// Creo un logger
	private static Logger logger = Logger.getLogger(LogConsole.class.getName());

	static {
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.INFO); // Set the log level
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINEST); // Set handler log level
		logger.addHandler(handler);
	}

	public static void main(String[] args) {

		// Log messages at all levels
		logger.severe("This is a SEVERE error message");
		logger.warning("This is a WARNING message");
		logger.info("This is an INFO message");
		logger.config("This is a CONFIG message");
		logger.fine("This is a FINE debug message");
		logger.finer("This is a FINER debug message (more detailed)");
		logger.finest("This is a FINEST debug message (most detailed)");
		
		LogConsole lc = new LogConsole();
		lc.somma(10, 20);
		
	}
	
	public int somma (int a, int b) {
		logger.info("Somma eseguita");
	return a+b;
	}
}
