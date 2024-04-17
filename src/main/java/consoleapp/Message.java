public class Message extends Accommodation{
    int request; // what kind of request you want to do 1 for insert 2 for search e.t.c
    int managerid;
    Accommodation acc;
    
    public Message(int request,int managerid,Accommodation acc){
        this.request = request;
        this.managerid = managerid;
        this.acc = acc;
    }
}
