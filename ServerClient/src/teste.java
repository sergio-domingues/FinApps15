import java.io.*;
import java.net.*;
class test {
	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket(4445);
		
		while (true) {
			System.out.println("esperando");
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("conexao");
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			System.out.println("leu");
			
			System.out.println("Received: " + clientSentence);
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}