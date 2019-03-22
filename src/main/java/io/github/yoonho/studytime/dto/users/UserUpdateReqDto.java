package io.github.yoonho.studytime.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateReqDto {
    private String userId;
    private String password;
    private String nickname;
    private String phone;
}
