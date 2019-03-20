package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoRequestDto {
    private String user_id;
    private String password;
    private String nickname;
    private String phone;
    private Integer point;
    private String authority;

    public Users toEntity(){
        return Users.builder()
                .userId(user_id)
                .password(password)
                .nickname(nickname)
                .phone(phone)
                .point(point)
                .authority(authority)
                .build();
    }
}
