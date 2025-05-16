import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calcolatrice {


	public Calcolatrice() {
		super();
	}


	private static Logger logger = Logger.getLogger(Calcolatrice.class.getName());

	static {
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.INFO); // Set the log level
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINEST); // Set handler log level
		logger.addHandler(handler);
	};

	public double somma(double a, double b) {
		logger.info("somma eseguita");

		return a + b;

	};

	public  double sottrazione(double a, double b) {
		logger.info("sottrazione eseguita");

		return a - b;

	};

	public  double moltiplicazione(double a, double b) {
		logger.info("moltiplicazione eseguita");

		return a * b;

	};

	public double divisione(double a, double b) {
		logger.info("divisione eseguita");

		return a / b;

	}

}
