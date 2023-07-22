package BackEndFunctional.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipment {

    public ArrayList<Address> addresses;
    public String commodity;
    public String key;
    public Object numberOfBids;
    public Object price;
    public String vehicleType;

   }
