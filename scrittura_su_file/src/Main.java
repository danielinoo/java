import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main {

public static void main(String[] args) throws IOException { 
//si può mettere throws IOException prima di { nel main per sostituire 
//i try catch sotto e permette di gestire le eccezioni

	Locale.setDefault(Locale.US); //ora i numeri con , sono con il .
//e le date sono mese-giorno-anno (US)

	LinkedList<WiFi> lwifi = new LinkedList<WiFi>();
	
	for(int i = 0; i < 10; i++) {
	lwifi.add(WiFi.MakeWifi());
	}
	
	for(var x:lwifi) {
	String a = String.format("%s,%s,%s,%f\n", x.getId(),x.getProtocollo(),
	x.getPassword(),x.getFrequenza());
	System.out.println(a);
	}

//************************ scrittura file ***********************

	var fou = Util.OpenFileForWriting("wifi.dat");
	for (var x : lwifi) {
	String a = String.format("%s,%s,%s,%f\n", x.getId(),x.getProtocollo(),
	x.getPassword(),x.getFrequenza());
	try {
	fou.write(a);
	}catch(IOException e) {
	e.printStackTrace();  //java ha bisogno particolare della
	  //gestione exception con Input Output 
	}
	}
	try {
	fou.close();
	}catch(IOException e) {
	e.printStackTrace();
	}

//****************** lettura file*******************

lwifi.clear();

BufferedReader fin = Util.OpenFileForReading("wifi.dat");
String riga = fin.readLine();
while (riga != null) { //finchè esiste una riga 

String[] items = riga.split(",");
WiFi it = new WiFi(items[0], items[1], items[2], Double.parseDouble(items[3]));

lwifi.add(it);
System.out.println(riga);

riga = fin.readLine(); //passa alla riga successiva

}
fin.close();

//FORMATO JSON
var tmp = """
{
"id": "aY8VACjmXCTHS5mc",
"Protocollo": "WPA",
"Password" : "cckIhsglZsF_kbM9jvi!fzv",
"Frequenza" : 2997526562.090276
}
""";

WiFi appo = WiFi.MakeWifi(); //genero un oggetto wifi con il metodo

//Dichiaro la stringa che conterrà la descrizione in formato json
String jsonString;
//Servono delle librerie(del professore)che gestiscono i json
//Properties sul progetto->Java build path->Libraries->
//add external jars e metti le librerie jar passate dal prof

//Crea quindi un oggetto ObjectMapper
ObjectMapper objectMapper = new ObjectMapper();
//oggetto delle referenced libraries
jsonString = objectMapper.writeValueAsString(appo);
System.out.println(jsonString);

WiFi nuovo = objectMapper.readValue(jsonString, WiFi.class);
System.out.println(nuovo);
//Da json lo converte nella classe passata come secondo parametro


//********************WRITE JSON DA LIST IN TXT**************************
fou = Util.OpenFileForWriting("wifi.txt");
for (var x : lwifi) {
String a = objectMapper.writeValueAsString(x);
fou.write(a+"\n");
}

fou.close();

}
}
