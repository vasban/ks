import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ManagerHandler extends Thread {
    Socket connection;
    ObjectInputStream managerInput;
    ObjectOutputStream managerOutput;
    static ArrayList<ManagerHandler> managerHandlers = new ArrayList<ManagerHandler>();
    int id;
    static ArrayList<Master> masterList = Master.getMasterArrayList();


    public ManagerHandler(Socket connection){
        try{
            this.connection = connection;
            managerOutput = new ObjectOutputStream(connection.getOutputStream());
            managerInput = new ObjectInputStream(connection.getInputStream());
            managerHandlers.add(this);
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    @Override
    public void run(){
        System.out.println("Manager has connected to"+currentThread().getName());

            //παρε ενα αντικειμενο message hash() στειλτο στον master
        try{
            Message message = (Message)managerInput.readObject();
            System.out.println("I got the message"+currentThread().getName()+message.acc.toString());
            masterList.get(1).messages.add(message);
            System.out.println(masterList.get(1).messages);
            System.out.println("I send it to the master");
            
        }catch(IOException io){
            io.printStackTrace();
        }catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }
    }
}
