import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.*;

public class JsonPrsr {

  // kaleitai eswterika
  private static JSONObject parser(String jsonFileName) {
    try {
      String content = new String(Files.readAllBytes(Paths.get(jsonFileName)));
      JSONObject room = new JSONObject(content);

      return room;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  // kaleis aythn apthn main kai dineis onoma toy json, exw valei to json eksw
  // apto src, isws thelei ligo peiragma sta paths
  public static Accommodation getAccomodationObject(String jsonFileName) {
    JSONObject room = parser(jsonFileName);
    return new Accommodation(
        room.getString("roomName"),
        room.getInt("noOfPersons"),
        room.getString("area"),
        room.getInt("stars"),
        room.getInt("noOfReviews"));
  }

  public static void main(String args[]) {
    System.out.println(
        getAccomodationObject("src\\main\\java\\consoleapp\\rooms.json"));

  }
}
