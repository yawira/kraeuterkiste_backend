package aw.krauterkiste.logIn.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String verifyPassword;

    public boolean passwordsMatch(){
        return verifyPassword.equals(password);
    }
}
