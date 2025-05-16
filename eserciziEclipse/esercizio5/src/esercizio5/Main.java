package esercizio5;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] schermo = new byte[8];
        schermo[0] = 0b00000000;
        schermo[1] = 0b00011000;
        schermo[2] = 0b00100100;
        schermo[3] = 0b01100110;
        schermo[4] = 0b01111110;
        schermo[5] = 0b01100110;
        schermo[6] = (byte)0b11100111;
        schermo[7] = 0b00000000;
        
        for (int i = 0; i < schermo.length; i++) {
        	schermo[i] ^= 0b11111111;
        }
        Disegna(schermo);
        byte[] ottoup = { 
                0b00011000, 
                0b00100100, 
                0b00100100, 
                0b00011000, 
                0b00000000, 
                0b00000000, 
                0b00000000,
                0b00000000 };

        byte[] ottodown = { 
                0b00000000, 
                0b00000000, 
                0b00000000, 
                0b00000000, 
                0b00011000, 
                0b00100100, 
                0b00100100,
                0b00011000 };
        Disegna(ottoup);
        Disegna(ottodown);
        
        for (int i = 0; i <ottoup.length; ) {
        	ottoup[i] |= ottodown[i];
        }
        Disegna(ottoup);
	}
	
	
	
	private static void Disegna(byte[] schermo) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i<schermo.length; i++) {
			byte b = schermo[i];
			int valore = 128;
			for (int pos = 0; pos < 8; pos++) {
				
				if ((b & valore) == 0) {
					System.out.print(' ');
				}else {
					System.out.print('X');
				}
				valore /=2;
				
			} System.out.println();
		}
		
	}

}