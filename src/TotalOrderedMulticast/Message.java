/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalOrderedMulticast;

import java.io.Serializable;

/**
 *
 * @author Luca
 */
public class Message implements Serializable {
    private Timestamp Timestamp;
    private String Body;
    private int who;
    private int tag;
    private int reicever;
       

    public Message(Timestamp timestamp,String body, Integer who) {
        this.Timestamp=timestamp;
        this.Body=body;
        this.who=who;
        
    }
    
    // costruttore messaggio REVISE_TS
    public Message(String body, Integer tag, Integer who, Timestamp timestamp){
        this.Body=body;
        this.Timestamp=timestamp;
        this.tag=tag;
        this.who=who;      
    }
    
    //costruttore messaggio PROPOSED_TS
    public Message(Integer who, Integer reicever, Integer tag, Timestamp timestamp){
        this.who=who;
        this.reicever=reicever;
        this.tag=tag;
        this.Timestamp=timestamp;
    }
    //costruttore messaggio FINAL_TS
    public Message(Integer tag, Timestamp timestamp, Integer who){
        this.tag=tag;
        this.Timestamp=timestamp;
        this.who=who;
    }

    public Timestamp getTimestamp() {
        return Timestamp;
    }

    public String getBody() {
        return Body;
    }

    public int getWho() {
        return who;
    }

    public void setTimestamp(Timestamp Timestamp) {
        this.Timestamp = Timestamp;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public void setWho(int who) {
        this.who = who;
    }
    
    
}

