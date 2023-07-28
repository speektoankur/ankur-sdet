package BackEndFunctional.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Date;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dob {
    public Date date;
    public int age;
}
