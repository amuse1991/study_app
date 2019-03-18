package io.github.yoonho.studytime.dto;

import io.github.yoonho.studytime.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
    private String user_id;
    private String password;
    private String nickname;
    private String phone;
    private Integer point;
    private String authority;

    public Users toEntity(){
        return Users.builder()
                .user_id(user_id)
                .password(password)
                .nickname(nickname)
                .phone(phone)
                .point(point)
                .authority(authority)
                .build();
    }
}
