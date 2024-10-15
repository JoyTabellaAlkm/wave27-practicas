package ar.com.mercadolibre.socialmeli2.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    private int id;
    private String username;
    @Setter
    private boolean isSeller;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
        this.isSeller = false;
    }
}
