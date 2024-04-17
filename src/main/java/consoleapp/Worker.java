import java.net.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

//Δες πως πρεπει να χωριστει το json 
public class Worker {
    ServerSocket workerServer;
    Socket masterSocket;
    Socket handlerSocket;
    int port;
    int numOfThreads;
    ObjectOutputStream output;
    ObjectInputStream input;

    public Worker(int port,int numOfThreads){
        this.port = port;
        this.numOfThreads = numOfThreads;
    }

    public void OpenServer(){
        try{
            workerServer = new ServerSocket(port);
            

            while(!workerServer.isClosed()){
                masterSocket = workerServer.accept();
                System.out.println("A new master has connected");
                
                
                Thread t = new MasterHandler(masterSocket);
                t.start();

            }
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            try{
                workerServer.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
    }

    public static void main(String[]args){
        Worker w1 = new Worker(5000,3);
        w1.OpenServer();
        // Worker w2 = new Worker(5001,3);
        // w2.OpenServer();
        
    }
   
}
