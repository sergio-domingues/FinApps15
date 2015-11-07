package coderdudos.printdonation.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;

public class Connection extends Observable{
    private Socket clientSocket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    final private int PORT = 4445;


    private static Connection ourInstance = new Connection();

    public static Connection getInstance() {
        return ourInstance;
    }

    private Connection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket = new Socket("172.16.2.231", PORT);
                    outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
                    inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                    setChanged();
                    notifyObservers(ConnectionMessages.CONNECTED.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void send(Object arg){
        try {
            outToServer.writeObject(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object read(){
        try {
            return inFromServer.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket.close();
                    setChanged();
                    notifyObservers(ConnectionMessages.DISCONNECTED);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
