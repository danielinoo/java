import java.io.IOException;

public class ClienteNonSync extends Thread{
	String nome;
	double somma;
	public ClienteNonSync(String nome, double somma) {
		super();
		this.nome = nome;
		this.somma = somma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSomma() {
		return somma;
	}
	public void setSomma(double somma) {
		this.somma = somma;
	}
	
	
	
	
	@Override
	public void run() {
		Contocorrente c = new Contocorrente();
		
		String nome_file = "/home/user/project/eclipse-workspace/java3_esercizio_conto_corrente/src/saldo.txt";
		
		
		try {
			
			double saldo = c.getSaldo(nome_file);
			
			System.out.println("saldo di "+ nome +":" + saldo);
			  try {
				c.PrelievoNonSynch(saldo, somma, nome_file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
