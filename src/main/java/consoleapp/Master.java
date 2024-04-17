import java.net.*;
import java.io.*;
import java.lang.reflect.InaccessibleObjectException;
import java.util.*;

public class Master extends Thread {
    private int id;
    private int port;
    private String name;
    ServerSocket masterServer;
    Socket managerSocket;
    public static ArrayList<Master> masterList = new ArrayList<Master>();
    ArrayList<Message> messages ;
    

   
    

    
    
    public Master(String name,int port){
        this.port = port;
        this.name = name;
        this.messages = new ArrayList<Message>();
        masterList.add(this);
       
    }

    public void startMasterServer(){
        try{
            masterServer = new ServerSocket(this.port);

            System.out.println(this.name +" has created a server");

            while(!masterServer.isClosed()){
                managerSocket = masterServer.accept();
                System.out.println("A new manager has connected!");

                Thread t = new ManagerHandler(managerSocket);

                t.start();
            }
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            try{
                masterServer.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
    }


    public static ArrayList<Master> getMasterArrayList(){
        return masterList;
    }
    
    
    
    public void run(){
        Socket workerSocket = null;
        ObjectOutputStream workerOutput = null;
        ObjectInputStream workerInput = null;

        try{
           workerSocket = new Socket("localhost",this.port);
           workerOutput = new ObjectOutputStream(workerSocket.getOutputStream());
           workerInput = new ObjectInputStream(workerSocket.getInputStream()); 
           System.out.println("Hello from master"+this.name);

           workerOutput.writeInt(Integer.parseInt(name));
           workerOutput.flush();

           
                // Accomodation acc1 = new Accomodation();
                // Accomodation acc2 = new Accomodation();
                // workerOutput.writeObject(acc1);
                // workerOutput.flush();
                // workerOutput.writeObject(acc2);
                // workerOutput.flush();
                
            while(!workerSocket.isClosed()){
                if(!this.messages.isEmpty()){
                    Message m = this.messages.get(0);
                    workerOutput.writeObject(m);
                    workerOutput.flush();
                    messages.remove(m);
                }
            }
        //    Accomodation acc1 = (Accomodation)workerInput.readObject();
           
        }catch(IOException io){
            io.printStackTrace();
        }
        // catch(ClassNotFoundException ce){
        //     ce.printStackTrace();
        // }
    
    }
    
    public static void main(String[] args) throws InterruptedException {
        Master m0 = new Master("0", 5000);
        m0.start();
        Master m1 = new Master("1",5000);
        m1.start();
        System.out.println(getMasterArrayList());
        // m1.sendAccomodation();
        // m2.sendAccomodation();
        Master server = new Master("server",5001);

        server.startMasterServer();

    

    }


}
