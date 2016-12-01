/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class ServerHandler implements Runnable {
    private Socket client;
    private int port;
    private HashSet<Integer> link;

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private static int nm;
    private Forwarder forward;
    public ServerHandler(Socket client,Integer port,HashSet<Integer> link) throws IOException {
        this.client=client;
        this.port=port;
        this.link=link;
    
        
        in=new ObjectInputStream(client.getInputStream());
        out=new ObjectOutputStream(client.getOutputStream());
        forward=new Forwarder(link);
    }


    @Override
    public void run() {
       
        
        
    }
    
}
