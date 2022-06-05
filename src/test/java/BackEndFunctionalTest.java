
import BackEndFunctional.Models.Root;
import BackEndFunctional.Models.Shipment;
import BackEndFunctional.Utility.TestBase;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

/**
 * Backend Test
 */
public class BackEndFunctionalTest extends TestBase {

    @Test(dataProvider = "backendData", description = "Validating if at least one shipment available for queried vehicleType")
    public void validateAtLeastOneShipmentWithVehicleType(int lon, int lat, String vehicleType){
          Root response = given()
                  .headers(headersHelper())
                  .and()
                  .queryParams(queryCoordinatesParamsHelper(lon,lat))
                  .get("/marketplace")
                  .as(Root.class);

          ArrayList<Shipment> shipments = response.getShipments();
          int consignments = 0;
          for(Shipment shipment : shipments){
              if(shipment.getVehicleType().contentEquals(vehicleType)){
                  consignments++;
              }
          }
          Assert.assertTrue(consignments>0);
    }

    @Test(dataProvider = "backendData", description = "Validating if at least one shipment available at queried coordinates")
    public void validateIfLocationIsHavingShipments(int lon, int lat){
        Root response = given()
                .headers(headersHelper())
                .and()
                .queryParams(queryCoordinatesParamsHelper(lon,lat))
                .get("/marketplace")
                .as(Root.class);

        Assert.assertTrue(response.getShipments().size()!=0);
    }


}
