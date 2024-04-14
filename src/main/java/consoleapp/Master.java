import java.net.*;
import java.io.*;
import java.util.*;

public class Master extends Thread {

    private Socket socket = null;
    private ObjectInputStream input = null;
    private ObjectOutputStream output = null;
    private String host;
    private int port;
    ArrayList<Accomodation> accArray ;

    
    
    public Master(String host,int port){

        this.host = host;
        this.port = port;


    }
        
    
    public void run(){
        try{
            socket = new Socket(this.host,this.port);
            Accomodation acc1 = new Accomodation("Bas",1,"Steri",5,0);
            Accomodation acc2 = new Accomodation("Vas",1,"Peri",5,0);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            output.writeObject(acc1);

            
            output.flush();

            System.out.println("I am going to sleep!");

            sleep(1000);

            System.out.println("I got here!");


        }catch (UnknownHostException e) {
            // TODO: handle exception
            System.out.println(e);
        }catch(IOException io){
            System.out.println(io);
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }
    
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        // Worker w1 = new Worker(5000);
        // Thread t1 = new Thread(w1);

        // Worker w2 = new Worker(5001);
        // Thread t2 = new Thread(w2);

        // t1.start();
        // t2.start();

       Master m1 = new Master("localhost", 6969);

       m1.start();
       m1.port = 6968;
       m1.start();


    }


}
