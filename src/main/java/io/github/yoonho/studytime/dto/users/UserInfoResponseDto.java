package io.github.yoonho.studytime.dto.users;

import io.github.yoonho.studytime.domain.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoResponseDto {
    private String user_id;
    private String nickname;
    private String phone;
    private Integer point;
    private String authority;

    public Users toEntity(){
        return Users.builder()
                .user_id(user_id)
                .nickname(nickname)
                .phone(phone)
                .point(point)
                .authority(authority)
                .build();
    }
}
