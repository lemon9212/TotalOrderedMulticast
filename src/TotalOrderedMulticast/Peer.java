/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class Peer {
    private ServerSocket serverSocket;
    private int myport;
    private HashSet<Integer> connection;
    private Forwarder forwarder;
    private Timestamp timestamp;
    

    public Peer(int port) throws IOException, ClassNotFoundException {
        this.myport=port;
        this.connection=new HashSet<>();
        this.serverSocket=new ServerSocket(port);
        this.forwarder=forwarder; /// ???
        timestamp= new Timestamp(0); // inizializzo il timestamp per ogni peer
        join();
        (new Thread(new ClientHandler(myport,connection))).start();
        Executor executor= Executors.newFixedThreadPool(1500);
        while(true){
        executor.execute(new ServerHandler(serverSocket.accept(),myport,connection));
        }
    }
     public void show(HashSet<Integer> neighbours){
         System.out.println("I  vicini di "+myport+" sono: ");
        Iterator it=neighbours.iterator();
        for(;it.hasNext();){
           System.out.println(" "+(Integer)it.next());
        }
        setConnection(neighbours); // aggiungo i miei vicini
     }
     public void join() throws IOException, ClassNotFoundException{
        Socket client=null;
        ObjectOutputStream out=null;
        ObjectInputStream in=null;
        client =new Socket("localhost",1099);
        out=new ObjectOutputStream(client.getOutputStream());
        in=new ObjectInputStream(client.getInputStream());
        out.writeObject((Integer)myport);
        show((HashSet<Integer>) in.readObject());
        client.close();
     }
     
     //concorrenza sul timestamp del peer (LT)
    public synchronized Integer getTimestamp(){
        return timestamp.getValore();
    }
    
    public synchronized void increaseTimestamp(){
        timestamp.increaseValore();
    }
    
    
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public int getMyport() {
        return myport;
    }

    public void setMyport(int myport) {
        this.myport = myport;
    }


    public HashSet<Integer> getConnection() {
        return connection;
    }

    public void setConnection(HashSet<Integer> connection) {
        this.connection = connection;
    }

     
    
public static void main(String args[]){
        try {
            System.out.println("choose a peer with number port: 10000,10001,10002,10003,10004,10006,10007");
            Scanner s=new Scanner(System.in);
            Peer peer=new Peer(s.nextInt());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Peer.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
        }
}
    
}
