package BackEndFunctional.Utility;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

@Getter
public class TestBase {
    public RequestSpecBuilder requestSpecBuilder;
    public RequestSpecification requestSpecification;
    public TestBase() {
        requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://randomuser.me");
        requestSpecification = requestSpecBuilder.build();
    }

    /**
     * Static data for testing using Data provider
     *
     * @return
     */
    @DataProvider(name = "backendData")
    public static Object[][] apiData() {
        return new Object[][]{{30, 30, "heavyDuty"}};
    }

    /**
     * Simple helper function to club query params into Map Object
     *
     * @param lon
     * @param lat
     * @return
     */
    public Map<String, Object> queryCoordinatesParamsHelper(int lon, int lat) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("lon", lon);
        queryParam.put("lat", lat);
        return queryParam;
    }

    /**
     * Simple static function to create headers for authentications
     *
     * @return
     */
    public Map<String, Object> headersHelper() {
        Map<String, Object> headers = new HashMap<>();
        return headers;
    }


}
