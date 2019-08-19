package aw.krauterkiste.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    public UserEntity(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Id
    /* strategy eingefügt, aufgrund der sonst eingefügten "hibernate" exception */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;

}