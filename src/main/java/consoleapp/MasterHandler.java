import java.io.*;
import java.net.*;
import java.util.*;

public class MasterHandler extends Thread {
    Socket connection;
    ObjectInputStream masterInput;
    ObjectOutputStream masterOutput;
    static ArrayList<MasterHandler> masterHandlers = new ArrayList<MasterHandler>();
    int id;


    public MasterHandler(Socket connection){
        try{
            this.connection = connection;
            masterOutput = new ObjectOutputStream(connection.getOutputStream());
            masterInput = new ObjectInputStream(connection.getInputStream());
            masterHandlers.add(this);
            
        
        }catch(IOException io){
            io.printStackTrace();
        }
    }
    


    @Override
    public void run(){
        System.out.println("master has connected to:" +currentThread().getName());
        while(connection.isConnected()){
            try{
                this.id = masterInput.readInt();
                // System.out.println("My name is "+currentThread().getName()+" and i have id:"+this.id);
                // Accomodation acc = (Accomodation)masterInput.readObject();
                // System.out.println("I got the accommodation :"+currentThread().getName());
                // Accomodation acc1 = (Accomodation)masterInput.readObject();
                // System.out.println("I got the accommodation :"+currentThread().getName()); 
                Message m = (Message)masterInput.readObject();
                System.out.println("I got the message "+currentThread().getName());
                // sleep(1000);
            }catch(IOException io){
                io.printStackTrace();
            }catch(ClassNotFoundException ce){
                ce.printStackTrace();
            }
            
        }
    }
}
