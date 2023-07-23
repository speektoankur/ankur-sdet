package BackEndFunctional.Models;

import lombok.Getter;

@Getter
public class Login {
    public String uuid;
    public String username;
    public String password;
    public String salt;
    public String md5;
    public String sha1;
    public String sha256;
}
