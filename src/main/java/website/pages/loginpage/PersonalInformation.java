package website.pages.loginpage;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PersonalInformation {
//    public String firstName;
    public String email;
    public String password;

}
