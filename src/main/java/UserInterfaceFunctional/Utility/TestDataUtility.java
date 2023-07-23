package UserInterfaceFunctional.Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * @author Ankur
 */
public class TestDataUtility extends JSONFileReader {
    public static TestDataUtility DataConnection;

    public TestDataUtility() {
    }

    /**
     * Function to create connection for Data Utility for Data Driven Run
     *
     * @return Test Data Connection instance
     */
    public static TestDataUtility getInstance() {
        if (DataConnection == null) {
            DataConnection = new TestDataUtility();
        }
        return DataConnection;
    }

    /**
     * @return DataProvider data array from JSON File
     * @throws IOException
     * @throws ParseException
     */
    @DataProvider(name = "customers")
    public static Object[][] testBankCustomer() throws IOException, ParseException {
        JSONArray jsonArray = getData("testData.json");
        Object[][] testData = new Object[jsonArray.size()][3];
        for (int entry = 0; entry < jsonArray.size(); entry++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(entry);
            testData[entry][0] = String.valueOf(jsonObject.get("firstname"));
            testData[entry][1] = String.valueOf(jsonObject.get("lastname"));
            testData[entry][2] = String.valueOf(jsonObject.get("pincode"));
        }
        return testData;
    }


}
