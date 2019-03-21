package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.utils.AuthorityName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserAuthDto {
    private String userId;
    private AuthorityName authority;

    public Users toEntity(){
        return Users.builder()
                .userId(userId)
                .authority(authority)
                .build();
    }

}
