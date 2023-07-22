package UserInterfaceFunctional.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class JSONFileReader {
    static Object dataObject;
    static JSONObject jsonObject;

    public static JSONArray getData(String fileName) throws IOException, ParseException {
        dataObject = new JSONParser().parse(new FileReader("./src/main/testData/"+fileName));
        jsonObject = (JSONObject) dataObject;
        JSONArray jsonArray = (JSONArray) jsonObject.get("data");
        Iterator iterator = jsonArray.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return jsonArray;
    }

}
