import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.*;
  
  
public class JsonPrsr{


  // kaleitai eswterika
  public JSONObject parsakos(String jsonFileName){
    
    try{
      
      String content = new String(Files.readAllBytes(Paths.get(jsonFileName)));
      JSONObject room = new JSONObject(content);
  
      return room ;

    }catch(IOException e){
      
      e.printStackTrace();  
      return null;    
    }
    
  }

  //kaleis aythn apthn main kai dineis onoma toy json, exw valei to json eksw apto src, isws thelei ligo peiragma sta paths
  public Accomodation getAccomodationObject(String jsonFileName){
    

    Accomodation acc = new Accomodation();
    JSONObject room = parsakos(jsonFileName);

    acc.setRoomName(room.getString("roomName"));
    acc.setArea(room.getString("area"));
    acc.setNOfPersons(room.getInt("noOfPersons"));
    acc.setStars(room.getInt("stars"));
    acc.setNOfReviews(room.getInt("noOfReviews"));
    

    System.out.println(acc);
    return acc;

  }

  public static void main(String args[]){

    JsonPrsr prs = new JsonPrsr();
    prs.getAccomodationObject("rooms.json");

  }
}
    
 

