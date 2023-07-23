package BackEndFunctional.Models;

import lombok.Getter;

@Getter
public class Location {
    public Street street;
    public String city;
    public String state;
    public String country;
    public int postcode;
    public Coordinates coordinates;
    public Timezone timezone;
}
