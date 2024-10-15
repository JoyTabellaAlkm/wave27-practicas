package ar.com.mercadolibre.socialmeli2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Follow {
    private User user;
    private User userToFollow;

    public Follow(User user, User userToFollow) {
        this.user = user;
        this.userToFollow = userToFollow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Follow follow = (Follow) o;

        return user.getId() == follow.user.getId() && userToFollow.getId() == follow.userToFollow.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), userToFollow.getId());
    }
}

