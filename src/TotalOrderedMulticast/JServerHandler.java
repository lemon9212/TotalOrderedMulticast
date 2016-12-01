/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Luca
 */
public class JServerHandler implements Runnable {
    private Socket client;
    private ObjectInputStream inSocket;
    private ObjectOutputStream outSocket;
    private TreeMap<Integer,HashSet<Integer>> tp;

    public JServerHandler(Socket client, TreeMap<Integer,HashSet<Integer>> tp) throws IOException {
        this.client = client;
        this.tp=tp;
        inSocket=new ObjectInputStream(client.getInputStream());
        outSocket=new ObjectOutputStream(client.getOutputStream());
    }
    

    @Override
    public void run() {
        int address;
        try {
            
            address = (Integer)inSocket.readObject();
            System.out.println("Server listening at "+client.getInetAddress()+"has received a request from peer: "+address);
            outSocket.writeObject((HashSet<Integer>)tp.get(address));

        } catch (IOException ex) {
            Logger.getLogger(JServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
