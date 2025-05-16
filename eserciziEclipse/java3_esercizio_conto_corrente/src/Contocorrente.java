import java.io.*;

public class Contocorrente {

	public double getSaldo(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		double saldo = Double.parseDouble(br.readLine());
		br.close();
		return saldo;

	}

	public void PrelievoNonSynch(double saldo, double somma, String filePath) throws Exception {
			Thread.sleep(3000);

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {
				
				double nuovoSaldo = saldo - somma;

				if (nuovoSaldo > 0) {
					fw = new FileWriter(new File(".").getCanonicalPath() + File.separator + "saldo.txt");
					bw = new BufferedWriter(fw);
					bw.write(nuovoSaldo + "");
				} else
					throw new Exception("Saldo insufficiente!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		}

	


		

	

	public synchronized void prelievo(double saldo, double somma, String filePath) throws Exception {
		Thread.sleep(3000);

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			
			double nuovoSaldo = saldo - somma;

			if (nuovoSaldo > 0) {
				fw = new FileWriter(new File(".").getCanonicalPath() + File.separator + "saldo.txt");
				bw = new BufferedWriter(fw);
				bw.write(nuovoSaldo + "");
			} else
				throw new Exception("Saldo insufficiente!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

}
