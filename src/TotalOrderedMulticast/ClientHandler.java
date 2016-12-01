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
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class ClientHandler implements Runnable {
    private int port;
    private int markID;
    private Forwarder forwarder;
    private Message revise_ts;
    private Message final_ts;
    private Message msg;
    private HashSet<Integer> connection;
    private Peer peer;

    public ClientHandler(int port,HashSet<Integer> connection) {
        this.port=port;
        this.markID=0;
        this.connection=connection;
       
        System.out.println("Sono il lato client del peer "+port+"i miei vicini sono ");
        for(int vicino: connection){
            System.out.println(vicino);
        }
        
        //E' la parte client del peer che chiede i vicini??
        
    }

    public int getPort() {
        return port;
    }

  

    public int getMarkID() {
        return markID;
    }


    public Forwarder getForwarder() {
        return forwarder;
    }

    public void setPort(int port) {
        this.port = port;
    }


    public void setForwarder(Forwarder forwarder) {
        this.forwarder = forwarder;
    }
        


    @Override
    public void run() {
        System.out.println(" sono il client :"+port);
        
        revise_ts= new Message(body, tag, port,timestamp);
       
        
    }
    
}

