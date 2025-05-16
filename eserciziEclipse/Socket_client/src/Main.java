
//project/eclipse-workspace/Socket_client/bin$ 

// sudo netstat -anp --tcp |grep (nome porta che ti serve)    ---> trovo le porte tcp collegate
// sudo kill -9 (codice del porcesso)
public class Main {

	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		
		client.Run("localhost", 32456);
	}

}
