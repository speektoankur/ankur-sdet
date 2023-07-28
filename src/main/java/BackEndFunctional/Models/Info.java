package BackEndFunctional.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    public String seed;
    public int results;
    public int page;
    public String version;
}
