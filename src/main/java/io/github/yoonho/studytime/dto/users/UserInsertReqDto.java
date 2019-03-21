package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.utils.AuthorityName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInsertReqDto {
    private String userId;
    private String password;
    private String nickname;
    private String phone;
    private Integer point;
    private AuthorityName authority;

    public Users toEntity(){
        return Users.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .phone(phone)
                .point(point)
                .authority(authority)
                .build();
    }
}
