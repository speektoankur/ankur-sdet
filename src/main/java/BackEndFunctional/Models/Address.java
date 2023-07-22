package BackEndFunctional.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    public String key;
    public Object latitude;
    public Object longitude;
    public String name;
    public String order;

}
