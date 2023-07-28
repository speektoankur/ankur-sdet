package BackEndFunctional.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    public ArrayList<Result> results;
    public Info info;


}
