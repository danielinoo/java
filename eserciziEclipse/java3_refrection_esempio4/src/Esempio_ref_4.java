import java.lang.*;
public class Esempio_ref_4 {

	public static void main(String[] args) {
		try {
			Class data = Class.forName("java.util.Date");  //ricerca classe
			
			Object oggetto = data.getDeclaredConstructors().newInstance();  //aggiunge nuovo oggetto
		
			System.out.println("Nome classe = "+ data.getName());
			System.out.println("Nome dell oggetto = " + oggetto.toString());
		
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
