package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserUpdateReqDto {
    private String userId;
    private String password;
    private String nickname;
    private String phone;

    public Users toEntity(){
        return Users.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .phone(phone)
                .build();
    }
}
