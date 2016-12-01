/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;

/**
 *
 * @author Luca
 */
public class Forwarder {
    private HashSet<Integer> links;
    
  
  

    public Forwarder(HashSet<Integer> link) {
        links =new HashSet<>();
        this.links=link;
        System.out.println(links.isEmpty());
    
       
       
    }

    public HashSet<Integer> getLinks() {
        return links;
    }

    public void setLinks(HashSet<Integer> links) {
        this.links = links;
    }
    
    

public void send(Message message,int port) throws IOException{
    Socket client=new Socket("localhost",port);
    ObjectOutputStream out=new ObjectOutputStream(client.getOutputStream());
    synchronized(this){
    out.writeObject(message);}
    
}
public void sendAll(Message message) throws IOException{
   ObjectOutputStream out=null;

  // Socket client(links.size()-1);
   for( int link:links){
      System.out.println("Dentro il forwarder faccio la sendall: "+Thread.currentThread().getName());
    
      out=new ObjectOutputStream((new Socket("localhost",link)).getOutputStream());
      synchronized(this){
      out.writeObject(message);}
      System.out.println("Sono il forwarder, sto inviando a: "+link);
   }
    
}
public void sendAll(Message message,int port) throws IOException{
       ObjectOutputStream out=null;
   
  // Socket client(links.size()-1);
   for( int link:links){
       System.out.println("vicino: "+link);
      if(link!=port){
       System.out.println("tranne: "+link);
      out=new ObjectOutputStream((new Socket("localhost",link)).getOutputStream());
      synchronized(this){
      out.writeObject(message);}
      }
   }
}
}

