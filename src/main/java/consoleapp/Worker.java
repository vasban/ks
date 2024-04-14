import java.net.*;
import java.util.*;
import java.io.*;

//Δες πως πρεπει να χωριστει το json 
public class Worker extends Thread {
    
    private Socket s = null;
    private ServerSocket ss;
    private ObjectInputStream input =null;
    private ObjectOutputStream output =null;

    ArrayList<Accomodation> accArray ;

    @Override
    public void run(){
        System.out.println("Thread started");
        System.out.println("Id " + Thread.currentThread().getName()
        );
        try{
            

            
            
            System.out.println("Client accepted");
            Accomodation acc = (Accomodation) input.readObject();

            acc.setRoomName("Bill was here");
            System.out.println(acc.toString());
            output.writeObject(acc);
            output.flush();
            


        }catch(IOException io){
            io.printStackTrace();
        }catch(ClassNotFoundException c){
            c.printStackTrace();
        }

    }

    public Worker(int port){
        try {
            
           this.ss = new ServerSocket(port);
           System.out.println("Server Started");

           System.out.println("Waiting for client");
           this.s = ss.accept();
           
           this.output = new ObjectOutputStream(s.getOutputStream());
			this.input = new ObjectInputStream(s.getInputStream());
            System.out.println("I got here worker");

          

           //s = ss.accept();
           

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println(e);

        }
    }

    public static void main(String [] args){


        Worker w1 = new Worker(6969);
        Thread t1 = new Thread(w1);

        Worker w2 = new Worker(6968);
        Thread t2 = new Thread(w2);

        
        // Worker w2 = new Worker(5001);
        // Thread t2 = new Thread(w2);

        t1.start();
        // t2.start();
    }
}
