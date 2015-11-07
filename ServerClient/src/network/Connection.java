package network;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Observable;

/**
 * Representa uma ligacao com o cliente
 * @author Sergio Domingues
 *
 */

public class Connection extends Observable implements Runnable {

	protected Socket clientSocket = null;
	
	private PrintWriter out;
	private BufferedReader in;

	//public static boolean created = false;
	//	private int id;
	public String lastMessage, ip;

	private boolean connected = false;
	
	/**
	 * Nova Ligação
	 * @param clientSocket Socket a que se vai ligar
	 */
	Connection(Socket clientSocket) {
		//created = true;
		connected = true;
		
		try {
			clientSocket.setSoTimeout(20000);
			out = new PrintWriter(clientSocket.getOutputStream(), true);			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.clientSocket = clientSocket;
		ip = clientSocket.getInetAddress().getHostAddress();		
	}

	/**
	 * Ip do Cliente
	 * @return Ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Obtem Id da Conexao
	 * @return Id Conexao
	 */
/*	public int getIdConnection() {
		return id;
	}*/

	/**
	 * Trata da Comunicao com o Cliente
	 */
	public void run() {
			while(true)		
				readMessage();
			//handle message  TODO FUNCAO PROTOCOLAR USAR OUT 		
	}

	/**
	 * Termina a Ligacao com o Cliente
	 */
	public synchronized void closeConnection() {
		try {
			connected = false;
		//	created = false;
			this.clientSocket.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Le mensagem do Cliente e notifica Observers
	 * @return Messagem Lida
	 */
	private String readMessage() {
		
		System.out.println("Reading Message\n");
		
		try {
			lastMessage = in.readLine();
			System.out.println(lastMessage + "\n");
			out.println("ACK\n");
			out.flush();
		} 
		catch (SocketTimeoutException e) {
			System.err.println("Socket Desconectada");
			closeConnection();
		} 
		catch (IOException e) {
			System.err.println("Erro a ler da Socket");
			e.printStackTrace();
		}

		if (lastMessage == null) {
			System.err.println("Cliente Desconectado");
			closeConnection();
		}
		else 
			System.out.println(lastMessage);
				

		//	setChanged();
		//notifyObservers(lastMessage);
		//clearChanged();

		return lastMessage;
	}

	/**
	 * Obtem a ultima mesagem recebida
	 * @return ultima Mensagem
	 */
	public String getLastMessage() {
		return lastMessage;
	}

	/**
	 * Verifica se esta ligado
	 * @return True se estiver/ False o contrario
	 */
	public boolean isConnected() {
		return connected;
	}

}