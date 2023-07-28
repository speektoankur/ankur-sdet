import BackEndFunctional.Models.Root;
import BackEndFunctional.Utility.TestBase;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Backend Test
 */
public class BackEndFunctionalTest extends TestBase {

    @Test(description = "Validating random results response")
    public void validateRandomUserGetAPI() {
        Response response = given()
                .spec(getRequestSpecification())
                .and()
                .get("/api")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        Root root = response.as(Root.class);
        Reporter.log(response.prettyPrint());
        Assert.assertNotNull(root.getResults().get(0).getPicture().getThumbnail());

    }
}
