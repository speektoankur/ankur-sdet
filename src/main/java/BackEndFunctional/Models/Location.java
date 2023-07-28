package BackEndFunctional.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    public Street street;
    public String city;
    public String state;
    public String country;
    public int postcode;
    public Coordinates coordinates;
    public Timezone timezone;
}
