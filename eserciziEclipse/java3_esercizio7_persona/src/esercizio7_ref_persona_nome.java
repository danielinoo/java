import java.lang.reflect.*;

public class esercizio7_ref_persona_nome {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, ClassNotFoundException {
		try {
			Persona p = new Persona();

			Field cercaNome = Persona.class.getDeclaredField("nome");
			cercaNome.setAccessible(true);
			System.out.println("ESERCIZIO 7");
			System.out.println("nome della persona: " + cercaNome.get(p));
			
			
			
			System.out.println();
			System.out.println("----------------------------------------");
			System.out.println();
			
			Class ClaPer = Class.forName("Persona");
			Method MetData;
			try {
				MetData = ClaPer.getDeclaredMethod("printData");
				
				System.out.println("ESERCIZIO 8: ");
				System.out.println("metodo print data: " + MetData);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
