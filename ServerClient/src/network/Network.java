package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Classe responsavel pelo sistema de rede Utiliza o padrao de desenho Singleton
 * *
 * 
 * @author Sergio Domingues
 *
 */

public class Network extends Thread {

	protected static Network instance = null; // singleton pattern

	protected static int maxConnections = 1;
	protected static String hostIp;

	protected ServerSocket serverSocket;
	protected Connection clientConnection = null;
	protected int nrConnections = 0;

	public enum ServerStatus {
		GETTINGCLIENT, COMMUNICATING, STOPPED
	};

	protected ServerStatus status;
	protected boolean isRunning = true;
	public final static int PORT = 4445; // TODO A VERIFICAR

	/**
	 * Cria uma ServerSocket e inicia as variaveis do servidor necessarias
	 */
	public Network() {
		status = ServerStatus.GETTINGCLIENT;

		// Connection.nextId = 1;
		this.nrConnections = 0;

		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			hostIp = InetAddress.getLocalHost().toString();
			System.out.println(hostIp);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg) {
		getInstance();

	}

	/**
	 * Aplicacao do Padrao Singleton Se nao existir nenhuma conexao cria uma e
	 * inicia o servidor, se já existir retorna essa ligação
	 * 
	 * @return Conexao
	 */
	public static Network getInstance() {
		if (instance == null) {
			instance = new Network();
			instance.start(); // start thread
		}
		return instance;
	}

	/**
	 * Inicia Servidor e consoante o estado executa determinadas operacoes Se
	 * estiver em: - GETTINGCLIENT ficà espera que os clientes se connectem até
	 * chegar ao limite definido - STOPPED termina todas as ligações dos
	 * clientes e encerra o servidor
	 */
	public void run() {
		System.out.println("running");
		Socket clientSocket;
		// while (status == ServerStatus.GETTINGCLIENT) {
		while (true) {

			try {
				clientSocket = this.serverSocket.accept();
				System.out.println("socket accepted");
				clientConnection = new Connection(clientSocket);
				new Thread(clientConnection).start();
				nrConnections++;

			} catch (IOException e) {
				System.err.println("Erro Criar Cliente");
				e.printStackTrace();
				return;
			}

			// //comunicacao estabelecidada
			status = ServerStatus.COMMUNICATING;

			// while (status == ServerStatus.COMMUNICATING) {
			System.out.println("Communication\n");

			while (status == ServerStatus.COMMUNICATING) {

			}

			// le mensagens
			// }

			if (status == ServerStatus.STOPPED) {
				clientConnection.closeConnection();
			}
		}
	}

	// System.err.println("Server Stopped.");

	// }

	/**
	 * Verifica se já exite determinada ligacao
	 * 
	 * @param ip
	 *            Ip da ligacao
	 * @return True- existir False se nao existir
	 */
	private boolean existConnection(String ip) {
		if (clientConnection != null && clientConnection.getIp().equals(ip)) {
			return true;
		} else
			return false;
	}

	/**
	 * Muda o estado do Servidor para STOPPED e faz reset da instance
	 */
	public synchronized void stopServer() {
		this.status = ServerStatus.STOPPED;

		try {
			this.serverSocket.close();
			instance = null;
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}

	/**
	 * Muda o estado do Servidor
	 * 
	 * @param status
	 *            Novo Estado
	 */
	public void changeStatus(ServerStatus status) {
		this.status = status;
	}

	/**
	 * Retorna as Ligações existentes aos diferentes Clientes
	 * 
	 * @return Array com as Ligações existentes
	 */
	synchronized public Connection getConnection() {
		return clientConnection;
	}

	/**
	 * Obtem o Nr Máximo de Ligações ao servidor
	 * 
	 * @return Nr Maximo de Ligações
	 */
	public static int getMaxConnection() {
		return maxConnections;
	}

	/**
	 * Atribui um novo Maximo de Conexoes
	 * 
	 * @param maxConnection
	 *            Novo máximo
	 */
	public static void setMaxConnection(int maxConnection) {
		Network.maxConnections = maxConnection;
	}

	/**
	 * Obtem o estado do servidor
	 * 
	 * @return Estado
	 */
	synchronized public ServerStatus getStatus() {
		return status;
	}

	/**
	 * Obtem o numero de conexoes activas
	 * 
	 * @return Nr de Conexoes activas
	 */
	synchronized public int getNrConnections() {
		return nrConnections;
	}

	/**
	 * Obtem o Local Ip do Servidor
	 * 
	 * @return Nome+ Ip do Servidor
	 */
	public static String getHostIp() {
		return hostIp;
	}

}